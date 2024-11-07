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
	file, err := os.ReadFile(fileName)
	if err != nil {
		log.Fatalf("failed to read file: %s %v", fileName, err)
	}
	def := ast.Parse(string(file), listener)
	fmt.Printf("%+v\n", def)
}
