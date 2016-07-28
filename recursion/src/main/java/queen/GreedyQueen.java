package queen;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Math.abs;


/**
 * Created by hp21 on 2015.09.08..
 */
public class GreedyQueen implements ISolver {

    private static final int DELAY = 922168000;

    private final SecureRandom random;

    public GreedyQueen() {
        random = new SecureRandom();
    }

    public static void main(String[] args) {
        new GreedyQueen().run();
    }

    private void run() {

        List<String> state = new ArrayList<>(Arrays.asList("0", "1", "2", "3"));
//        solve(state);
        System.out.println("=========================");
        List<String> state1 = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4"));
//        solve(state1);
        System.out.println("=========================");

        List<String> state1a = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6"));
//        solve(state1a);
        System.out.println("=========================");

        //        List<String> state1b = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8"));
        //        solve(state1b);
        //        System.out.println("=========================");
        //
        //        //        List<String> state2 = new ArrayList<>(Arrays.asList("5", "8", "0", "2", "4", "1", "7", "9", "3", "6"));
        //        List<String> state2 = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        //        solve(state2);
        //        System.out.println("=========================");
        //
        //        List<String> state3 = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"));
        //        solve(state3);
        //        System.out.println("=========================");

        List<String> state4 = new ArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            state4.add("" + i);
        }

        System.out.println(new Date());
        solve(state4);
        System.out.println(new Date());
        System.out.println("=========================");

    }

    @Override
    public void solve(List<String> state) {
        int solvedInPass = 0;

        final AtomicBoolean go = new AtomicBoolean(true);

        for (int i = 0; i < 10; i++) {

            System.out.printf("Pass: %d\n", i);

            randomizeElements(state);
            go.getAndSet(true);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                               @Override
                               public void run() {
                                   go.getAndSet(false);
                               }
                           },
                    DELAY
            );

            while (thereAreConflicts(state) && go.get()) {
                swap(state);
            }

            timer.purge();

            if (!thereAreConflicts(state)) {
                solvedInPass = i + 1;
                break;
            }


        }

        if (thereAreConflicts(state)) {
            System.out.println("No solution");
        } else {
            System.out.printf("Solved in %2d pass.\n%s\n", solvedInPass, state);

        }
    }

    void randomizeElements(List<String> state) {
        for (int z = 0; z < (state.size() < 5 ? 2 : state.size() / 2); z++) {
            randomChangeTwoElements(state);
        }
    }

    void randomChangeTwoElements(List<String> state) {
        int one = random(state.size() - 1);
        int two = random(state.size() - 1);
        changeTwoElementPosition(state, one, two);
    }

    void changeTwoElementPosition(List<String> state, int one, int two) {
        String t1 = state.get(one);
        state.set(one, state.get(two));
        state.set(two, t1);
    }

    boolean thereAreConflicts(List<String> state) {
        return conflicts(state) != 0;
    }

    void swap(List<String> state) {
        int k = 0, j = 0, conf;
        String temp;

        conf = conflicts(state);

        boolean inConflict = true;
        while (k == j || inConflict) {
            int max = state.size() - 1;
            k = random(max);
            j = random(max);
            inConflict = abs(k - j) == 1 && conflictingPlace(state, k, j);
        }

        //swap
        temp = state.get(k);
        state.set(k, state.get(j));
        state.set(j, temp);

        if (conflicts(state) < conf) {
            System.out.println("" + state + ", k=" + k + ", j=" + j + " prev conf=" + conf);
            return;
        }

        //swap bacj
        temp = state.get(k);
        state.set(k, state.get(j));
        state.set(j, temp);
        //        System.out.printf("In vain attempt, state=%s with k=%s, k=%s\n", state, k, j);

    }

    int conflicts(List<String> state) {

        int count = 0, i, j;

        for (i = 0; i < state.size(); i++) {
            for (j = i + 1; j <= state.size() - 1; j++) {
                if (conflictingPlace(state, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean conflictingPlace(List<String> state, int i, int j) {
        return abs(toInt(state.get(i)) - toInt(state.get(j))) == abs(j - i);
    }

    private int random(int max) {
        return nextInt(0, max);
    }


    /**
     * @param min generated value. Can't be > then max
     * @param max generated value
     * @return values in closed range [min, max].
     */
    private int nextInt(int min, int max) {
        if (min == max) {
            return max;
        }

        return random.nextInt(max - min + 1) + min;
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }

}