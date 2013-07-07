package nfa;

import java.util.HashSet;
import java.util.Set;

public class NFA {

    private final Set<String> startStates;
    private Set<String> currentStates;
    private final Set<String> acceptStates;
    private final NFARuleBook ruleBook;

    public NFA(Set<String> currentStates, Set<String> acceptStates, NFARuleBook ruleBook) {
        this.acceptStates = new HashSet<String>(acceptStates);
        this.startStates = this.currentStates = currentStates;
        this.ruleBook = ruleBook;
    }

    public boolean accepting() {
        acceptStates.retainAll(currentStates);
        return !acceptStates.isEmpty();
    }

    public void readCharacter(char character) {
        currentStates = ruleBook.nextStates(currentStates, character);
    }

    public void readString(String input) {
        for (char chr : input.toCharArray()) {
            readCharacter(chr);
        }
    }

    public NFA toDFA() {
        return new NFA(startStates, acceptStates, ruleBook);
    }

    @Override
    public String toString() {
        return "DFA{" + "acceptStates=" + acceptStates + ", currentStates='" + currentStates + '\'' + ", ruleBook=" + ruleBook + '}';
    }
}
