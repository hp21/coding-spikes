package fa;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFA {

    String currentState;
    Set<String> acceptState;
    DFARuleBook ruleBook;

    public DFA(String currentState, Collection<String> acceptState, DFARuleBook ruleBook) {
        this.acceptState = new HashSet<String>(acceptState);
        this.currentState = currentState;
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
}
