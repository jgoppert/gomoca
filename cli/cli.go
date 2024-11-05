package main

import (
	"fmt"
	"gomoca/ast"
	"os"
)

func main() {
	listener := ast.NewListener()
	fileName := os.Args[1]
	def := ast.Parse(fileName, listener)
	fmt.Printf("%+v\n", def)
}
