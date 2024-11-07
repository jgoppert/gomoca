package ast

import (
	"fmt"
	"gomoca/parser"
	"log"
	"strconv"
	"strings"

	"github.com/antlr4-go/antlr/v4"
)

type Listener struct {
	*parser.BaseModelicaListener
	Depth int // used for debug printing
	// ScopeDefinition       Stack[Definition]
	// ScopeClass            Stack[Class]
	// ScopeComponent        Stack[Component]
	// ScopeEquationSection  Stack[EquationSection]
	// ScopeAlgorithmSection Stack[AlgorithmSection]
	// ScopeEquation         Stack[Equation]
	// ScopeStatement        Stack[Statement]
	Ast map[any]any
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
	fmt.Println(strings.Repeat("-", l.Depth), "enter",
		parser.ModelicaParserStaticData.RuleNames[c.GetRuleIndex()])
	l.Depth += 1 // decrease tree Depth
}

func (l *Listener) ExitEveryRule(c antlr.ParserRuleContext) {
	l.Depth -= 1 // decrease tree Depth
	fmt.Println(strings.Repeat("-", l.Depth), "exit",
		parser.ModelicaParserStaticData.RuleNames[c.GetRuleIndex()])
	fmt.Printf("%+v\n", l.Ast[c])
}

// -----------------------------------------------------------------------------
// Stored Definition
//
// This is the root of the AST
// -----------------------------------------------------------------------------
func (l *Listener) ExitStored_definition(c *parser.Stored_definitionContext) {
	d := *NewDefinition()
	for i, class_def := range c.AllClass_definition() {
		class, ok := l.Ast[class_def].(Class)
		if ok {
			class.Final = c.FINAL(i) != nil
			d.Classes[class.Name] = class
		} else {
			println("not ok")
		}
	}
	l.Ast[c] = d
}

func (l *Listener) ExitClass_definition(c *parser.Class_definitionContext) {
	class_spec, ok := l.Ast[c.Class_specifier()]
	if !ok {
		panic("key")
	}
	d := class_spec.(Class)
	d.Partial = l.Ast[c.Class_prefixes().PARTIAL()].(bool)
	d.Type = c.Class_prefixes().Class_type().GetText()
	l.Ast[c] = d
}

func (l *Listener) ExitClass_specifier_long(c *parser.Class_specifier_longContext) {
	d := *NewClass()
	if c.GetName_start().GetText() != c.GetName_end().GetText() {
		panic("class start name %s and end name %s don't match")
	}
	d.Name = c.GetName_start().GetText()
	d.Description = c.Description_string().GetText()
	//d.Components = l.Ast[c.Composition().Element_list()]
	l.Ast[c] = d
}

func (l *Listener) ExitElement_component_clause(c *parser.Element_component_clauseContext) {
	l.Ast[c] = l.Ast[c.Component_clause()]
}

func (l *Listener) ExitElement_list(c *parser.Element_listContext) {
	l.Ast[c] = l.Ast[c.AllElement()[0]]
}

func (l *Listener) ExitComponent_declaration(c *parser.Component_declarationContext) {
	l.Ast[c] = l.Ast[c.Declaration()]
}

func (l *Listener) ExitDeclaration(c *parser.DeclarationContext) {
	l.Ast[c] = c.IDENT()
}

func (l *Listener) ExitComponent_clause(c *parser.Component_clauseContext) {
	l.Ast[c] = l.Ast[c.Component_list()]
}

func (l *Listener) ExitComponent_list(c *parser.Component_listContext) {
	l.Ast[c] = l.Ast[c.AllComponent_declaration()[0]]
}

func (l *Listener) ExitClass_type_block(c *parser.Class_type_blockContext) {
	l.Ast[c] = c.GetText()
}

func (l *Listener) ExitClass_prefixes(c *parser.Class_prefixesContext) {
	l.Ast[c.PARTIAL()] = c.PARTIAL() != nil
}

func (l *Listener) ExitDescription_string(c *parser.Description_stringContext) { // unset class scope
	l.Ast[c] = c.GetText()
}

func (l *Listener) ExitDescription(c *parser.DescriptionContext) { // unset class scope
	l.Ast[c] = l.Ast[c.Description_string()]
}

func (l *Listener) ExitEquation_simple(c *parser.Equation_simpleContext) {
	l.Ast[c] = &Equation{
		Left:  l.Ast[c.Simple_expression()],
		Right: l.Ast[c.Expression()]}
}

// -----------------------------------------------------------------------------
// Primary
// -----------------------------------------------------------------------------
func (l *Listener) ExitComponent_reference(c *parser.Component_referenceContext) {
	ref := ComponentReference{Local: c.GetLocal() != nil}
	for _, c_scope := range c.AllComponent_scope() {
		scope, ok := l.Ast[c_scope]
		if !ok {
			log.Fatalf("key: %p not found", c_scope)
		}
		ref.Scopes = append(ref.Scopes, scope.(ComponentReferenceScope))
	}
	l.Ast[c] = ref
}

func (l *Listener) ExitComponent_scope(c *parser.Component_scopeContext) {
	d := ComponentReferenceScope{Name: c.IDENT().GetText()}
	l.Ast[c] = d

}

func (l *Listener) ExitPrimary_component_reference(c *parser.Primary_component_referenceContext) {
	l.Ast[c] = l.Ast[c.Component_reference()]
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
	l.Ast[c] = l.Ast[c.Simple_expression()]
}

func (l *Listener) ExitFunction_arguments(c *parser.Function_argumentsContext) {
	// TODO
	l.Ast[c] = l.Ast[c.Expression()]
}

func (l *Listener) ExitFunction_call_args(c *parser.Function_call_argsContext) {
	// TODO
	l.Ast[c] = l.Ast[c.Function_arguments()]
}

func (l *Listener) ExitPrimary_derivative(c *parser.Primary_derivativeContext) {
	// TODO
	l.Ast[c] = l.Ast[c.Function_call_args()]
}

func (l *Listener) ExitComposition_equation_section(c *parser.Composition_equation_sectionContext) {
	// TODO
	//l.Ast[c] = l.Ast[c]
	l.Ast[c] = l.Ast[c.AllEquation()[0]]
}

func (l *Listener) ExitComposition(c *parser.CompositionContext) {
	// TODO
	l.Ast[c] = l.Ast[c.Composition_non_first(0)]
}
