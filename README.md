# Toy-Language-Interpreter

A toy language interpreter in Java with JavaFX GUI using the Model-View-Controler architectural plan.

## Model:
#### ADT: 
`MyIStack`, `MyIDict`, `MyIHeap`, `MyIList` interfaces and `MyStack`, `MyDict`, `MyHeap`, `MyList` classes which implement them
#### Expressions: 
`IExpression` interface and  `ArithmeticExpression`, `LogicExpression`, `ReadHeapExpression`, `RelationalExpression`, `ValueExpression`, `VariableExpression` which implement it
#### Program state: 
execution stack, symbol table, output list, file table, heap table
#### Statements: 
`IStatement` interface which is implemented by `AssignStatement`, `CompoundStatement`, `ForkStatement`, `IfStatement`, `NewStatement`, `NoOperationStatement`, `PrintStatement`, `VariableDeclarationStatement`, `WhileStatement`, `WriteHeapStatement`, `ReadFile`, `OpenReadFile`, `CloseReadFile`
#### Types: 
`IType` interface which is implemented by `BoolType`, `IntType`, `ReferenceType`, `StringType`
#### Values: 
`IValue` interface which is implemented by `BoolValue`, `IntValue`, `ReferenceValue`, `StringValue`

## Exceptions:
`ADTException`, `DivisionByZero`, `ExpressionEvaluationException`, `InterpreterException`, `ProgramStateException`, `StatementExecutionException`

## Repository
`IRepository` interface implemented by `Repository`

## Controller
oneStep execution, garbage collector, getHeapAddress, getSymbolTableAddress 


## View
console-based menu to run hard-coded programs


## GUI
- a window to select the programs
- a window to execute the selected program
<img src="https://user-images.githubusercontent.com/91715582/222975468-ae137fd3-e25f-420a-b169-ed4264544b7a.png" alt="drawing" style="width:600px;"/>
<img src="https://user-images.githubusercontent.com/91715582/222975645-e53f2ae7-4f35-42a6-8442-aeb6ffcdd2a0.png" alt="drawing" style="width:600px;"/>
