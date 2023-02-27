package Model.expressions;

import Model.adt.MyIDict;
import Model.adt.MyIHeap;
import Model.types.BoolType;
import Model.types.IType;
import Model.types.IntType;
import Model.values.BoolValue;
import Model.values.IValue;
import exceptions.ADTException;
import exceptions.DivisionByZero;
import exceptions.ExprEvalException;

import java.util.Objects;

public class LogicExpression implements IExpression{
    IExpression expr1;
    IExpression expr2;
    String operator;

    public LogicExpression(IExpression e1, IExpression e2, String o){
        expr1 = e1;
        expr2 = e2;
        operator = o;
    }
    @Override
    public IValue eval(MyIDict<String, IValue> symTable, MyIHeap heap) throws ExprEvalException, ADTException, DivisionByZero {
        IValue value1, value2;
        value1 = expr1.eval(symTable, heap);
        if (value1.getType().equals(new BoolType())) {
            value2 = expr2.eval(symTable, heap);
            if (value2.getType().equals(new BoolType())) {
                BoolValue bool1 = (BoolValue) value1;
                BoolValue bool2 = (BoolValue) value2;
                boolean b1, b2;
                b1 = bool1.getValue();
                b2 = bool2.getValue();
                if (Objects.equals(operator, "and")) {
                    return new BoolValue(b1 && b2);
                } else if (Objects.equals(operator, "or")) {
                    return new BoolValue(b1 || b2);
                }
            } else {
                throw new ExprEvalException("Second operand is not a boolean.");
            }
        } else {
            throw new ExprEvalException("First operand is not a boolean.");
        }
        return null;
    }

    @Override
    public IExpression deepCopy() {
        return new LogicExpression(expr1.deepCopy(), expr2.deepCopy(), operator);
    }

    @Override
    public IType typeCheck(MyIDict<String, IType> typeEnv) throws ExprEvalException, ADTException {
        IType type1, type2;
        type1 = expr1.typeCheck(typeEnv);
        type2 = expr2.typeCheck(typeEnv);
        if (type1.equals(new BoolType())) {
            if (type2.equals(new BoolType())) {
                return new BoolType();
            } else
                throw new ExprEvalException("Second operand is not a boolean.");
        } else
            throw new ExprEvalException("First operand is not a boolean.");
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + operator + " " + expr2.toString();
    }
}
