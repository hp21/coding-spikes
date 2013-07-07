package fa;

/**
 * Created User: Peter Horvath Date: 2013.07.05. Time: 19:32
 */
public class FARule {

    public final static char NIL = '\u0000';

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

    @Override
    public String toString() {
        return "FARule{" + "state=" + state + '\'' + ", character=" + character + ",  nextState='" + nextState + '\'' + '}';
    }
}
