package expression;

/**
 * Created by u292148 on 2016.01.15..
 */
public class Machine {

    private IExpression expression;

    public Machine(IExpression expression) {
        this.expression = expression;
    }

    public void step() {
        this.expression = this.expression.reduce();
    }

    public void run() {
        while (expression.isReducible()) {
            System.out.println(expression);
            step();
        }

        System.out.println(expression);
    }

}
