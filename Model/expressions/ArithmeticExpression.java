package Model.expressions;

import Model.adt.MyIDict;
import Model.adt.MyIHeap;
import Model.types.IType;
import Model.types.IntType;
import Model.values.IValue;
import Model.values.IntValue;
import exceptions.ADTException;
import exceptions.DivisionByZero;
import exceptions.ExprEvalException;

public class ArithmeticExpression implements IExpression{
    IExpression expr1;
    IExpression expr2;
    char operator;

    public ArithmeticExpression(char o, IExpression e1, IExpression e2) {
        expr1 = e1;
        expr2 = e2;
        operator = o;
    }
    @Override
    public IValue eval(MyIDict<String, IValue> symTable, MyIHeap heap) throws ExprEvalException, ADTException, DivisionByZero {
        IValue value1, value2;
        value1 = expr1.eval(symTable, heap);
        if (value1.getType().equals(new IntType())) {
            value2 = expr2.eval(symTable, heap);
            if (value2.getType().equals(new IntType())) {
                IntValue int1 = (IntValue) value1;
                IntValue int2 = (IntValue) value2;
                int a, b;
                a = int1.getValue();
                b = int2.getValue();
                if (operator == '+')
                    return new IntValue(a + b);
                else if (operator == '-')
                    return new IntValue(a - b);
                else if (operator == '*')
                    return new IntValue(a * b);
                else if (operator == '/')
                    if (b == 0)
                        throw new DivisionByZero("ERROR: DIVISION BY ZERO!");
                    else
                        return new IntValue(a / b);
            } else
                throw new ExprEvalException("ERROR: Second operand is not an integer.");
        } else
            throw new ExprEvalException("ERROR: First operand is not an integer.");
        return null;
    }

    @Override
    public IExpression deepCopy() {
        return new ArithmeticExpression(operator, expr1.deepCopy(), expr2.deepCopy());
    }

    @Override
    public IType typeCheck(MyIDict<String, IType> typeEnv) throws ExprEvalException, ADTException {
        IType type1, type2;
        type1 = expr1.typeCheck(typeEnv);
        type2 = expr2.typeCheck(typeEnv);
        if (type1.equals(new IntType())) {
            if (type2.equals(new IntType())) {
                return new IntType();
            } else
                throw new ExprEvalException("ERROR: Second operand is not an integer.");
        } else
            throw new ExprEvalException("ERROR: First operand is not an integer.");
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + operator + " " + expr2.toString();
    }
}
