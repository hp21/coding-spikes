package sp;

/**
 * Created by U292148 on 2016.05.10..
 */
public class Infimum {
    private static final int RRR = 14;
    private static int num = RRR;

    public static void main(String[] args) {
        new Infimum().run(num);
    }

    public void run(final int num) {

        double sum = 1.0;

        for (double n = 2.0; n < num; n++) {
            sum = sum * (1 - (1 / n));
        }

        System.out.printf("Sum: %1.12f\n", sum);
    }
}
