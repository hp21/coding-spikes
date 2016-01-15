package expression;

/**
 * Created by u292148 on 2016.01.15..
 */
public class Add implements IExpression {

    private final IExpression left;
    private final IExpression right;

    public Add(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    public static Add create(IExpression left, IExpression right) {
        return new Add(left, right);
    }


    @Override
    public IExpression reduce() {
        if (left.isReducible()) {
            return Add.create(left.reduce(), right);
        } else if (right.isReducible()) {
            return Add.create(left, right.reduce());
        } else {
            return Number.create(((Number) left).number() + ((Number) right).number());
        }
    }

    @Override
    public String inspect() {
        return left.inspect() + " + " + right.inspect();
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
