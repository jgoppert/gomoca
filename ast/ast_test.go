package ast

import (
	"fmt"
	"gomoca/resources"
	"log"
	"testing"
)

func do_parsing(fileName string) {
	listener := NewListener()
	file, err := resources.Content.ReadFile(fileName)
	if err != nil {
		log.Fatalf("%s does not exist", fileName)
	}
	def := Parse(string(file), listener)
	fmt.Printf("%+v\n", def)
}

func TestBouncingBall(t *testing.T) {
	do_parsing("models/bouncing_ball.mo")
}
