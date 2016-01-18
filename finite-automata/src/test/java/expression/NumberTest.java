package expression;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by u292148 on 2016.01.15..
 */
public class NumberTest {

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void testNumBasic() {

        Number number1 = Number.create(12);
        assertEquals("12", number1.inspect());
    }

    @Test
    public void testMoreBasic() {

        Add expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));


        System.out.println(expression.inspect());

    }

    @Test
    public void testReducible() {

        assertFalse(Number.create(2).isReducible());
        assertTrue(Add.create(Number.create(2), Number.create(4)).isReducible());
        assertTrue(Multiply.create(Number.create(2), Number.create(4)).isReducible());

    }

    @Test
    public void testReducibleReduice() {

        Map<String ,IExpression> environment = new HashMap<>();

        IExpression expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));


        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        expression = expression.reduce(environment);
        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        expression = expression.reduce(environment);
        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        expression = expression.reduce(environment);
        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        System.out.println("While\n\n");


        expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));

        while (expression.isReducible()) {
            System.out.println(expression.inspect());
            expression = expression.reduce(environment);
        }

        System.out.println(expression.inspect());


    }

    @Test
    public void testReduceWithMachine() {

        Map<String ,IExpression> environment = new HashMap<>();

        IExpression expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));

        Machine machine = new Machine(expression, environment);

        machine.run();

    }

    @Test
    public void testReduceWithMachineLess() {
        Map<String ,IExpression> environment = new HashMap<>();
        Machine m = new Machine(LessThan.create(Number.create(5), Add.create(Number.create(2), Number.create(2))), environment);

        m.run();

        m = new Machine(LessThan.create(Number.create(5), Add.create(Number.create(7), Number.create(2))),environment);

        m.run();

    }

    @Test
    public void testReduceWithVar() {

        HashMap<String, IExpression> environment = new HashMap<>();
        environment.put("x", Number.create(3));
        environment.put("y", Number.create(4));

        Machine machine = new Machine(Add.create(Variable.create("x"), Variable.create("y")), environment);

        machine.run();
    }
    ;


}