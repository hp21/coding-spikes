package expression;

import java.util.Map;

/**
 * Created by hp21 on 2016.01.15..
 */
public class BooleanValue implements IExpression {

    private final Boolean value;

    public BooleanValue(java.lang.Boolean value) {
        this.value = value;
    }

    public static BooleanValue create(Boolean num) {
        return new BooleanValue(num);
    }

    public Boolean number() {
        return value;
    }

    @Override
    public String inspect() {
        return "" + value;
    }

    @Override
    public boolean isReducible() {
        return false;
    }

    @Override
    public IExpression reduce(Map environment) {
        throw new IllegalArgumentException("No recude on Number");
    }


    @Override
    public String toString() {
        return inspect();
    }
}
