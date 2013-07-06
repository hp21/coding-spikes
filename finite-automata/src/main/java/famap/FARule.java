package famap;

/**
 * Created User: Peter Horvath Date: 2013.07.05. Time: 19:32
 */
public class FARule {

    final private State state;
    final private char character;
    final private State nextState;

    private IStateFactory factory = new StateFactory();

    public FARule(State state, char character, State nextState) {
        this.character = character;
        this.nextState = nextState;
        this.state = state;
    }

    public FARule(String state, char character, String nextState) {
        factory = new StateFactory();

        this.state = factory.produce(state);
        this.character = character;
        this.nextState = factory.produce(nextState);
    }

    public boolean appliesTo(State state, char character) {
        return this.state == state && this.character == character;
    }

    public State follow() {
        return nextState;
    }

    public char getCharacter() {
        return character;
    }

    public State getNextState() {
        return nextState;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "FARule{" + "character='" + character + '\'' + ", state='" + state + '\'' + ", nextState='" + nextState + '\'' + '}';
    }
}
