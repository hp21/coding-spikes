package expression;

import java.util.Map;

/**
 * Created by hp21 on 2016.01.15..
 */
public class Machine {

    private Map<String, IExpression> environment;
    private IExpression expression;

    public Machine(IExpression expression, Map<String, IExpression> environment) {
        this.expression = expression;
        this.environment = environment;
    }

    public void step() {
        this.expression = this.expression.reduce(environment);
    }

    public void run() {
        while (expression.isReducible()) {
            System.out.println(expression);
            step();
        }

        System.out.println(expression);
    }

}
