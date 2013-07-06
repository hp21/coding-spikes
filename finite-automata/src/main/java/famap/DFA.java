package famap;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DFA {

    final State startState;
    State currentState;
    final Set<State> acceptState;
    final DFARuleBookMap ruleBook;

    public DFA(State currentState, Collection<State> acceptState, DFARuleBookMap ruleBook) {
        this.acceptState = new HashSet<State>(acceptState);
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
