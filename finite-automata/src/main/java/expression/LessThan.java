package expression;

import java.util.Map;

/**
 * Created by u292148 on 2016.01.15..
 */
public class LessThan implements IExpression {

    private final IExpression left;
    private final IExpression right;

    public LessThan(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    public static LessThan create(IExpression left, IExpression right) {
        return new LessThan(left, right);
    }


    @Override
    public IExpression reduce(Map environment) {
        if (left.isReducible()) {
            return LessThan.create(left.reduce(environment), right);
        } else if (right.isReducible()) {
            return LessThan.create(left, right.reduce(environment));
        } else {
            return BooleanValue.create(((Number) left).number() < ((Number) right).number());
        }
    }

    @Override
    public String inspect() {
        return left.inspect() + " < " + right.inspect();
    }

    @Override
    public boolean isReducible() {
        return true;
    }

    @Override
    public String toString() {
        return inspect();
    }
}
