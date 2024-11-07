package ast

import (
	"errors"
)

type Stack[T any] struct {
	s []*T
}

func NewStack[T any]() *Stack[T] {
	return &Stack[T]{make([]*T, 0, 10)}
}

func (s *Stack[T]) Push(v *T) {
	s.s = append(s.s, v)
}

func (s *Stack[T]) Pop() (*T, error) {
	l := len(s.s)
	if l == 0 {
		return nil, errors.New("empty stack")
	}

	res := s.s[l-1]
	s.s = s.s[:l-1]
	return res, nil
}

func (s *Stack[T]) Last() (*T, error) {
	l := len(s.s)
	if l == 0 {
		return nil, errors.New("empty stack")
	}

	res := s.s[l-1]
	return res, nil
}
