package recursion;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

/**
 * User: u292148 Date: 2013.06.10. Time: 12:22
 */
public class Dice {

    private final Random random;
    private final int numberOfThrows;

    public Dice(int numberOfThrows) {
        random = new Random();
        this.numberOfThrows = numberOfThrows;
    }

    public List<Integer> throwDice() {
        return throwDice(1);
    }

    private List<Integer> throwDice(int level) {

        if (level >= numberOfThrows) {
            List<Integer> value = Lists.newArrayList(random6());
            return value;
        }

        final List<Integer> dices = throwDice(level + 1);
        dices.add(0, random6());

        return dices;
    }

    private int random6() {
        return (int) Math.floor(random.nextDouble() * 5 + 1.5);
    }
}
