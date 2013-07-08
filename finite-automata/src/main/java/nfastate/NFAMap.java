package nfastate;

import com.google.common.collect.Sets;
import famap.State;

import java.util.HashSet;
import java.util.Set;

public class NFAMap {

    private final Set<State> startStates;
    private Set<State> currentStates;
    private final Set<State> acceptStates;
    private final NFARuleBook ruleBook;

    public NFAMap(Set<State> currentStates, Set<State> acceptStates, NFARuleBook ruleBook) {
        this.currentStates = currentStates;
        this.startStates = new HashSet<State>(currentStates);
        this.acceptStates = acceptStates;
        this.ruleBook = ruleBook;
    }

    public void readString(String input) {
        for (char chr : input.toCharArray()) {
            readCharacter(chr);
        }
    }

    public boolean accepting() {
        return !Sets.intersection(acceptStates, currentStates).isEmpty();
    }

    /**
     * FIXME: Does not work!!
     *
     * @return
     */
    public NFAMap toNFA() {
        return new NFAMap(startStates, acceptStates, ruleBook);
    }

    private void readCharacter(char character) {
        currentStates = ruleBook.nextStates(findAllCurentStates(currentStates), character);
    }

    private Set<State> findAllCurentStates(Set<State> states) {
        return ruleBook.followFreeMoves(states);
    }

    @Override
    public String toString() {
        return "DFA{" + "acceptStates=" + acceptStates + ", currentStates='" + currentStates + '\'' + ", ruleBook=" + ruleBook + '}';
    }
}
