package main

import (
	"errors"
	"fmt"
	"gomoca/ast"
	"log"
	"os"
)

func main() {
	listener := ast.NewListener()
	fileName := os.Args[1]
	if _, err := os.Stat(fileName); errors.Is(err, os.ErrNotExist) {
		log.Fatalf("%s does not exist", fileName)
	}
	def := ast.Parse(fileName, listener)
	fmt.Printf("%+v\n", def)
}
