package sicp;

/**
 * Created by U292148 on 2014.11.28..
 */
public class Accumulator implements IAccumulator {
    @Override
    public int acc(int sum, int i) {
        return sum + i;
    }
}
