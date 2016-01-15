package analizis;

/**
 * Created by HP on 2015.12.20..
 * <p>
 * <p>
 * From elementary real analizis 2.6.6
 * <p>
 * 1/1+1/2+1/3+....+1/n sum
 */
public class Sum1 {

    private final long num;

    public Sum1(String intStr) {

        num = Long.valueOf(intStr);
    }

    public static void main(String[] args) {
        double result = new Sum1(args[0]).run();

        System.out.printf("Result %d\n", result);
    }

    private double run() {

        double val = 0L;

        for (long i = 0; i < num; i++) {
            val = +1 / i;
        }

        return val;
    }


}
