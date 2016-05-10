package mod;

import java.util.function.IntBinaryOperator;

/**
 * Created by HP21 on 2016.05.04..
 */
public class Modulo {

    private static IntBinaryOperator addOp = (left, right) -> left + right;
    private static IntBinaryOperator multOp = (left, right) -> left * right;

    public static void main(String[] args) {
        new Modulo().run(8, addOp);
//        new Modulo().run(5, multOp);

    }

    public void run(final int num, final IntBinaryOperator operator) {

        System.out.printf("num: %d, op: %s\n\n", num, operator == addOp ? " + " : " * ");
        System.out.printf("%3s", operator == addOp ? "+" : "*");

        //headers
        for (int i = 0; i < num; i++) {
            System.out.printf("|%3d", i);
        }

        System.out.println("|");

        separatorLine(num);

        for (int i = 0; i < num; i++) {
            System.out.printf("%3d|", i); // row label

            for (int j = 0; j < num; j++) {
                System.out.printf("%3d|", operator.applyAsInt(i, j) % num);
            }

            System.out.println();

            separatorLine(num);

        }

    }

    private void separatorLine(final int num) {
        for (int q = 1; q < 4 * (num + 1); q++) {
            System.out.print(q % 4 == 0 ? "+" : "-");
        }
        System.out.println("+");
    }
}
