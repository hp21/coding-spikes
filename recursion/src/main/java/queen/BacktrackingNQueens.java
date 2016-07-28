package queen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp21 on 2015.09.13..
 */
public class BacktrackingNQueens {

    private int max;

    List<Integer> state;

    public static void main(String[] args) {
        new BacktrackingNQueens().run();
    }

    private void run() {
        state = createState(8);

        queens(0);
    }

    private void queens(int i) {
        if (promising(i)) {
            if (i == max - 1) {
                System.out.println(state);
            } else {
                for (int j = 0; j < max; j++) {
                    state.set(i + 1, j);
                    queens(i + 1);
                }
            }
        }
    }

    boolean promising(int i) {
        int k = 0;
        boolean promising = true;

        while (k < i && promising) {
            if (state.get(i) == state.get(k) || (Math.abs(state.get(i) - state.get(k)) == i - k)) {
                promising = false;
                break;
            }

            k = k + 1;
        } //while

        return promising;
    }

    public List<Integer> createState(int max) {

        this.max = max;
        List<Integer> state = new ArrayList<>();
        for (int z = 0; z < max; z++) {
            state.add(z);
        }

        return state;
    }

}
