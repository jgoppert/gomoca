package ast

//=========================================================
//  Classes
//=========================================================

type Definition struct {
	Classes map[string]Class
}

func NewDefinition() *Definition {
	p := new(Definition)
	p.Classes = make(map[string]Class)
	return p
}

type Class struct {
	Name              string
	Components        map[string]Component
	AlgorithmSections []AlgorithmSection
	EquationSections  []EquationSection
	Partial           bool
	Type              string
	Final             bool
	Description       string
}

func NewClass() *Class {
	m := new(Class)
	m.Components = make(map[string]Component)
	m.AlgorithmSections = make([]AlgorithmSection, 0, 100)
	m.EquationSections = make([]EquationSection, 0, 100)
	return m
}

type Component struct {
	Name string
}

//=========================================================
//  Algorithms and Equations
//=========================================================

type Equation struct {
	Left  any
	Right any
}

type Statement struct {
	Left  any
	Right any
}

type EquationSection struct {
	Initial   bool
	Equations []Equation
}

func NewEquationSection() *EquationSection {
	e := new(EquationSection)
	e.Equations = make([]Equation, 0, 100)
	e.Initial = false
	return e
}

type AlgorithmSection struct {
	Initial    bool
	Statements []Statement
}

func NewAlgorithmSection() *AlgorithmSection {
	a := new(AlgorithmSection)
	a.Initial = false
	a.Statements = make([]Statement, 0, 100)
	return a
}

//=========================================================
//  Primary
//=========================================================

type UnsignedInteger struct {
	Value uint
}

type Boolean struct {
	Value bool
}

type String struct {
	Value string
}

// =========================================================
//
//	Binary Operations
//
// =========================================================
type Multiply struct {
	Left  any
	Right any
}
type ElemMultiply struct {
	Left  any
	Right any
}
type Divide struct {
	Left  any
	Right any
}
type ElemDivide struct {
	Left  any
	Right any
}
type Exponential struct {
	Left  any
	Right any
}
type ElemExponential struct {
	Left  any
	Right any
}
type Add struct {
	Left  any
	Right any
}
type ElemAdd struct {
	Left  any
	Right any
}
type Subtract struct {
	Left  any
	Right any
}
type ElemSubtract struct {
	Left  any
	Right any
}

type ComponentReference struct {
	Local  bool
	Scopes []ComponentReferenceScope
}

type ComponentReferenceScope struct {
	Name       string
	Subscripts []uint
}

// =========================================================
//
//	Unary Operations
//
// =========================================================
type Negative struct {
	Value any
}
