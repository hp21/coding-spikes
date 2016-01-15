package expression;

/**
 * Created by u292148 on 2016.01.15..
 */
public interface IExpression {


    String inspect();

    boolean isReducible();

    IExpression reduce();



}
