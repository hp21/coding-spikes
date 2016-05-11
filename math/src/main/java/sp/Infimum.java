package sp;

import java.math.BigDecimal;

/**
 * Created by U292148 on 2016.05.10..
 */
public class Infimum {
    private static final int RRR = 18;
    private static int num = RRR;

    public static void main(String[] args) {
        new Infimum().run(num);
    }

    public void run(final int num) {

        BigDecimal sum = BigDecimal.valueOf(1.0);

        for (int n = 2; n < num; n++) {
            BigDecimal multiplier = BigDecimal.valueOf(1.0 - 1.0 / Math.pow(2, n));
            sum = sum.multiply(multiplier);
        }

        System.out.printf("Sum: %1.42f\n", sum);
    }
}
