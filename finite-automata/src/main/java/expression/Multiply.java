package expression;

import java.util.Map;

/**
 * Created by hp21 on 2016.01.15..
 */
public class Multiply implements IExpression {

    private final IExpression left;
    private final IExpression right;

    public Multiply(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    public static Multiply create(IExpression left, IExpression right) {
        return new Multiply(left, right);
    }


    @Override
    public String inspect() {
        return left.inspect() + " * " + right.inspect();
    }

    @Override
    public boolean isReducible() {
        return true;
    }

    @Override
    public IExpression reduce(Map environment) {
        if (left.isReducible()) {
            return Multiply.create(left.reduce(environment), right);
        } else if (right.isReducible()) {
            return Multiply.create(left, right.reduce(environment));
        } else {
            return Number.create(((Number) left).number() * ((Number) right).number());
        }
    }

    @Override
    public String toString() {
        return inspect();
    }


}
