package expression;

import org.junit.Before;
import org.junit.Test;

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

        IExpression expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));


        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        expression = expression.reduce();
        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        expression = expression.reduce();
        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        expression = expression.reduce();
        System.out.println(expression.inspect());
        System.out.println("expression: " + expression.inspect() + " redcible? " + expression.isReducible());

        System.out.println("While\n\n");


        expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));

        while (expression.isReducible()) {
            System.out.println(expression.inspect());
            expression = expression.reduce();
        }

        System.out.println(expression.inspect());


    }

    @Test
    public void testReduceWithMachine() {

        IExpression expression = Add.create(
                Multiply.create(Number.create(1), Number.create(2)),
                Multiply.create(Number.create(3), Number.create(4)));

        Machine machine = new Machine(expression);

        machine.run();

    }



    }