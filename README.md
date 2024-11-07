# gomoca ![CI](https://github.com/jgoppert/gomoca/actions/workflows/go.yml/badge.svg)

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

## Development

If you change the ANTLR grammar in parser/Modelica.g4, you must regenerate the parser
```bash
go generate ./...

```

### Using Go Run Cmd
```bash
go run ./cmd/gomoca/ resources/models/bouncing_ball.mo 
```

### Building in Local Directory
```bash
mkdir -p bin && go build -o bin ./...
```

### Debugging
Make sure you install dlv. Instruction for VSCode [here](https://github.com/golang/vscode-go/blob/master/docs/debugging.md)

* gomoca Vscode Debug Config: This config runs a modelica model (current file in VSCode) with gomoca and starts the debugger.
