package ast

import (
	"fmt"
	"gomoca/parser"
	"strconv"

	"github.com/antlr4-go/antlr/v4"
)

type Listener struct {
	*parser.BaseModelicaListener
	Depth                 int         // used for debug printing
	Def                   *Definition // root of AST
	ScopeClass            *Class      // class scope
	ScopeComponent        *Component
	ScopeEquationSection  *EquationSection
	ScopeAlgorithmSection *AlgorithmSection
	ScopeEquation         *Equation
	ScopeStatement        *Statement
	Ast                   map[any]any
}

func Parse(file string, listener *Listener) Definition {
	input, _ := antlr.NewFileStream(file)
	lexer := parser.NewModelicaLexer(input)
	stream := antlr.NewCommonTokenStream(lexer, 0)
	p := parser.NewModelicaParser(stream)
	p.AddErrorListener(antlr.NewDiagnosticErrorListener(true))
	tree := p.Stored_definition()
	antlr.ParseTreeWalkerDefault.Walk(listener, tree)
	return Definition{}
}

func NewListener() *Listener {
	l := new(Listener)
	l.Ast = make(map[any]any)
	l.Depth = 0
	return l
}

// -----------------------------------------------------------------------------
// Every Rule
// -----------------------------------------------------------------------------
func (l *Listener) EnterEveryRule(c antlr.ParserRuleContext) {
	//fmt.Println(strings.Repeat("-", l.Depth), "enter",
	//	parser.ModelicaParserStaticData.RuleNames[c.GetRuleIndex()])
	l.Depth += 1 // decrease tree Depth
}

func (l *Listener) ExitEveryRule(c antlr.ParserRuleContext) {
	l.Depth -= 1 // decrease tree Depth
	//fmt.Println(strings.Repeat("-", l.Depth), "exit",
	//	parser.ModelicaParserStaticData.RuleNames[c.GetRuleIndex()])
}

// -----------------------------------------------------------------------------
// Stored Definition
//
// This is the root of the AST
// -----------------------------------------------------------------------------
func (l *Listener) ExitStored_definition(c *parser.Stored_definitionContext) {
	//fmt.Printf("def: %+v\n", l.Ast[c])
}

// -----------------------------------------------------------------------------
// Class Scope
// -----------------------------------------------------------------------------
func (l *Listener) EnterClass_definition(c *parser.Class_definitionContext) {
}

func (l *Listener) ExitLong_class_specifier(c *parser.Long_class_specifierContext) {
}

func (l *Listener) ExitClass_definition(c *parser.Class_definitionContext) { // unset class scope
}

// -----------------------------------------------------------------------------
// Component Scope
// -----------------------------------------------------------------------------
func (l *Listener) EnterComponent_declaration(c *parser.Component_declarationContext) {
}

func (l *Listener) ExitDeclaration(c *parser.DeclarationContext) {
}

func (l *Listener) ExitComponent_declaration(c *parser.Component_declarationContext) { // unset component scope
}

// -----------------------------------------------------------------------------
// Equation Section Scope
// -----------------------------------------------------------------------------
func (l *Listener) EnterComposition_equation_section(c *parser.Composition_equation_sectionContext) {
}

func (l *Listener) ExitComposition_equation_section(c *parser.Composition_equation_sectionContext) {

}

// -----------------------------------------------------------------------------
// Equation Scope
// -----------------------------------------------------------------------------
func (l *Listener) EnterEquation(c *parser.EquationContext) {
}

func (l *Listener) ExitEquation_simple(c *parser.Equation_simpleContext) {
	l.Ast[c] = Equation{
		Left:  l.Ast[c.Simple_expression()],
		Right: l.Ast[c.Expression()]}
	fmt.Printf("%v\n", l.Ast[c])
}

// -----------------------------------------------------------------------------
// Algorithm Section Scope
// -----------------------------------------------------------------------------
func (l *Listener) EnterComposition_algorithm_section(c *parser.Composition_algorithm_sectionContext) {
}

func (l *Listener) ExitComposition_algorithm_section(c *parser.Composition_algorithm_sectionContext) {
}

// -----------------------------------------------------------------------------
// Primary Scope
// -----------------------------------------------------------------------------
func (l *Listener) ExitPrimary_component_referenceContext(c *parser.Primary_component_referenceContext) {
}

func (l *Listener) ExitPrimary_unsigned_number(c *parser.Primary_unsigned_numberContext) {
	i, err := strconv.Atoi(c.GetText())
	if err != nil {
		panic(err)
	}
	l.Ast[c] = UnsignedInteger{Value: uint(i)}
}

func (l *Listener) ExitPrimary_true(c *parser.Primary_trueContext) {
	l.Ast[c] = Boolean{Value: true}
}

func (l *Listener) ExitPrimary_false(c *parser.Primary_falseContext) {
	l.Ast[c] = Boolean{Value: false}
}

func (l *Listener) ExitFactor(c *parser.FactorContext) {
	primary := c.AllPrimary()
	n := len(primary)
	left := l.Ast[primary[0]]
	if n == 1 {
		l.Ast[c] = left
	} else if n == 2 {
		op := c.GetOp().GetText()
		right := l.Ast[primary[1]]
		if op == "^" {
			l.Ast[c] = Exponential{Left: left, Right: right}
		} else if op == ".^" {
			l.Ast[c] = ElemExponential{Left: left, Right: right}
		}
	} else {
		panic("exponential cannot have more than 2 arguments")
	}
}

func (l *Listener) ExitTerm(c *parser.TermContext) {
	factor := c.AllFactor()
	n := len(factor)
	res := l.Ast[factor[0]]
	for i := 0; i < n-1; i++ {
		op := c.GetOp()[i].GetText()
		left := res
		right := factor[i+1]
		switch op {
		case "*":
			res = Multiply{Left: left, Right: right}
		case ".*":
			res = ElemMultiply{Left: left, Right: right}
		case "/":
			res = Divide{Left: left, Right: right}
		case "./":
			res = ElemDivide{Left: left, Right: right}
		}
	}
	l.Ast[c] = res
}

func (l *Listener) ExitArithmetic_expression(c *parser.Arithmetic_expressionContext) {
	term := c.AllTerm()
	n := len(term)
	res := l.Ast[term[0]]
	if c.GetSign() != nil {
		sign := c.GetSign().GetText()
		// not clear what .+ and .- would do for "element-wise" unary
		switch sign {
		case "-":
			res = Negative{Value: res}
		}
	}
	for i := 0; i < n-1; i++ {
		op := c.GetOp()[i].GetText()
		left := res
		right := term[i+1]
		switch op {
		case "+":
			res = Add{Left: left, Right: right}
		case "-":
			res = ElemMultiply{Left: left, Right: right}
		case ".+":
			res = Divide{Left: left, Right: right}
		case ".-":
			res = ElemDivide{Left: left, Right: right}
		}
	}
	l.Ast[c] = res
}

func (l *Listener) ExitRelation(c *parser.RelationContext) {
	// TODO
	expr := c.AllArithmetic_expression()
	l.Ast[c] = l.Ast[expr[0]]
}

func (l *Listener) ExitLogical_term(c *parser.Logical_termContext) {
	// TODO
	relation := c.Relation()
	l.Ast[c] = l.Ast[relation]
}

func (l *Listener) ExitLogical_expression(c *parser.Logical_expressionContext) {
	// TODO
	term := c.AllLogical_term()
	l.Ast[c] = l.Ast[term[0]]
}

func (l *Listener) ExitSimple_expression(c *parser.Simple_expressionContext) {
	// TODO
	expr := c.AllLogical_expression()
	l.Ast[c] = l.Ast[expr[0]]
}

func (l *Listener) ExitExpression_simple(c *parser.Expression_simpleContext) {
	// TODO
	println("exit expression simple", c.GetText())
	l.Ast[c] = l.Ast[c.Simple_expression()]
}

// func (l *Listener) ExitPrimary_component_scope(c *parser.Component_scopeContext) {
// 	l.Ast[c] = Scope{}
// }

// func (l *Listener) ExitPrimary_component_reference(c *parser.Primary_component_referenceContext) {
// 	local := c.Component_reference().GetLocal() != nil
// 	scopes := c.Component_reference().AllComponent_scope()
// 	s := ""
// 	if local {
// 		s += "."
// 	}
// 	for _, scope := range scopes {
// 		s += scope.IDENT().GetText()
// 	}
// }
