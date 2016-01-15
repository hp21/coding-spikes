package expression;

import com.google.common.base.MoreObjects;

/**
 * Created by u292148 on 2016.01.15..
 */
public class Number implements IExpression {

    private final Integer num;

    public Number(Integer num) {
        this.num = num;
    }

    public static Number create(Integer num) {
        return new Number(num);
    }

    public Integer number() {
        return num;
    }

    @Override
    public String inspect() {
        return "" + num;
    }

    @Override
    public boolean isReducible() {
        return false;
    }

    @Override
    public IExpression reduce() {
        throw new IllegalArgumentException("No recude on Number");
    }


    @Override
    public String toString() {
        return inspect();
    }
}
