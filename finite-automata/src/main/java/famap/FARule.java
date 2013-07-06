package famap;

/**
 * Created User: Peter Horvath Date: 2013.07.05. Time: 19:32
 */
public class FARule {

    String state;
    char character;
    String nextState;

    public FARule(String state, char character, String nextState) {
        this.character = character;
        this.nextState = nextState;
        this.state = state;
    }


    public boolean appliesTo(String state, char character) {
        return this.state == state && this.character == character;
    }

    public String follow() {
        return nextState;
    }

    public char getCharacter() {
        return character;
    }

    public String getNextState() {
        return nextState;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "FARule{" + "character='" + character + '\'' + ", state='" + state + '\'' + ", nextState='" + nextState + '\'' + '}';
    }
}
