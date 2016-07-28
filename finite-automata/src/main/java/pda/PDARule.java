package pda;

import java.util.List;

/**
 * Created User: Peter Horvath/hp21 Date: 2013.07.09. Time: 13:19
 */
public class PDARule {
    private PDAState state;
    private char character;
    private PDAState nextState;
    private char popCharacter;
    private List<Character> pushCharacters;

    public PDARule(PDAState state, char character, PDAState nextState, char popCharacter, List<Character> pushCharacters) {
        this.character = character;
        this.nextState = nextState;
        this.popCharacter = popCharacter;
        this.pushCharacters = pushCharacters;
        this.state = state;
    }

    public boolean appliesTo(PDAConfiguration configuration, char character) {
        return state == configuration.getState() && popCharacter == configuration.getStack().pop() && this.character == character;
    }

    public char getCharacter() {
        return character;
    }

    public PDAState getNextState() {
        return nextState;
    }

    public char getPopCharacter() {
        return popCharacter;
    }

    public List<Character> getPushCharacters() {
        return pushCharacters;
    }

    public PDAState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "PDARule{" + "character=" + character + ", state=" + state + ", nextState=" + nextState + ", popCharacter=" + popCharacter
                + ", pushCharacters=" + pushCharacters + '}';
    }
}
