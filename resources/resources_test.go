package resources

import (
	"testing"
)

func TestRead(t *testing.T) {
	_, err := Content.ReadFile("models/bouncing_ball.mo")
	if err != nil {
		panic(err)
	}
}
