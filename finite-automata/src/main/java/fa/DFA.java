package fa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DFA {

    final String startState;
    String currentState;
    final Set<String> acceptState;
    final DFARuleBook ruleBook;

    public DFA(String currentState, Collection<String> acceptState, DFARuleBook ruleBook) {
        this.acceptState = new HashSet<String>(acceptState);
        this.startState = this.currentState = currentState;
        this.ruleBook = ruleBook;
    }

    public boolean accepting() {
        return acceptState.contains(currentState);
    }

    public void readCharacter(char character) {
        currentState = ruleBook.nextState(currentState, character);
    }

    public void readString(String input) {
        for (char chr : input.toCharArray()) {
            readCharacter(chr);
        }
    }

    public DFA toDFA() {
        return new DFA(startState, acceptState, ruleBook);
    }

    @Override
    public String toString() {
        return "DFA{" + "acceptState=" + acceptState + ", currentState='" + currentState + '\'' + ", ruleBook=" + ruleBook + '}';
    }
}
