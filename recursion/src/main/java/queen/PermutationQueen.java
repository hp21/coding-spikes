package queen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import group3.Permutation;

/**
 * Created by U292148 on 2015.09.08..
 */
public class PermutationQueen implements ISolver {

    private GreedyQueen checker = new GreedyQueen();

    public static void main(String[] args) {
        new PermutationQueen().run();
    }

    private void run() {
        List<String> state = new ArrayList<>(Arrays.asList("0", "1", "2", "3"));
        solve(state);

        System.out.println("================================");
        state = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "5", "6", "7", "8", "9"));
        solve(state);

        System.out.println("================================");
        state = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "5", "6", "7", "8", "9", "10", "11", "12"));
        solve(state);
    }

    @Override
    public void solve(List<String> state) {

        Permutation permutator = new Permutation();
        List<List<String>> permutions = permutator.permute(state);

        for (List<String> permutation : permutions) {
            if (!checker.thereAreConflicts(permutation)) {
                System.out.println(permutation);
            }
        }
    }
}
