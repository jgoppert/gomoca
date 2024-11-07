# gomoca

A Modelica Compiler written in GO.

## Generating, Testing, and Installing

Install [Go](https://go.dev/doc/install)

Note in Go (...) means to run the command recursively in all sub directories.

```bash
go generate ./...
go test ./...
go install ./...
```

Remember to add GOBIN to your path: [GO Compile Install](https://go.dev/doc/tutorial/compile-install)

### Execute the Compiler

```bash
gomoca resources/models/bouncing_ball.mo
```

## Building In Directory
```bash
mkdir -p bin && go build -o bin ./...
```

## Test CLI
```bash
go run ./cli test/test.mo
```
