package nfa;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NFA {

    private final Set<String> startStates;
    private Set<String> currentStates;
    private final Set<String> acceptStates;
    private final NFARuleBook ruleBook;

    public NFA(Set<String> currentStates, Set<String> acceptStates, NFARuleBook ruleBook) {
        this.currentStates = currentStates;
        this.startStates = new HashSet<String>(currentStates);
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
    public NFA toNFA() {
        return new NFA(startStates, acceptStates, ruleBook);
    }

    private void readCharacter(char character) {
        currentStates = ruleBook.nextStates(findAllCurentStates(currentStates), character);
    }

    private Set<String> findAllCurentStates(Set<String> states) {
        return ruleBook.followFreeMoves(states);
    }

    @Override
    public String toString() {
        return "DFA{" + "acceptStates=" + acceptStates + ", currentStates='" + currentStates + '\'' + ", ruleBook=" + ruleBook + '}';
    }
}
