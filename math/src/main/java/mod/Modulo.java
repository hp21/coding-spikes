package mod;

import java.util.function.IntBinaryOperator;

/**
 * Created by HP21 on 2016.05.04..
 */
public class Modulo {

    private static IntBinaryOperator addOp = (left, right) -> left + right;
    private static IntBinaryOperator multOp = (left, right) -> left * right;

    public static void main(String[] args) {
        new Modulo().run(5, addOp);
//        new Modulo().run(5, multOp);

    }

    public void run(final int num, final IntBinaryOperator operator) {

        System.out.println(String.format("num: %d, op: %s", num, operator == addOp ? " + " : " * "));
        System.out.print("   ");

        //headers
        for (int i = 0; i < num; i++) {
            System.out.print(String.format("|%3d", i));
        }

        System.out.println("|");
        System.out.println(String.format(String.format("%%%ds", 4 * (num + 1)), " ").replace(" ", "-"));

        for (int i = 0; i < num; i++) {
            System.out.print(String.format("%3d|", i)); // row label

            for (int j = 0; j < num; j++) {
                System.out.print(String.format("%3d|", operator.applyAsInt(i, j) % num));
            }

            System.out.println();
            System.out.println(String.format(String.format("%%%ds", 4 * (num + 1)), " ").replace(" ", "-")); //separator line


        }

    }
}
