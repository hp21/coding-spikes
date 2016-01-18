package expression;

import java.util.Map;

/**
 * Created by u292148 on 2016.01.15..
 */
public class Variable implements IExpression {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public static Variable create(String  num) {
        return new Variable(num);
    }

    public String  number() {
        return name;
    }

    @Override
    public String inspect() {
        return "" + name;
    }

    @Override
    public boolean isReducible() {
        return true;
    }

    @Override
    public IExpression reduce(Map<String,IExpression> environment) {
       return environment.get(name);
    }


    @Override
    public String toString() {
        return inspect();
    }
}
