package pda;

/**
 * Created User: Peter Horvath/ Date: 2013.07.09. Time: 13:15
 */
public class PDAConfiguration {

    private PDAState state;
    private PDAStack stack;

    public PDAConfiguration(PDAState state, PDAStack stack) {
        this.stack = stack;
        this.state = state;
    }

    public PDAStack getStack() {
        return stack;
    }

    public PDAState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "PDAConfiguration{" + "stack=" + stack + ", state=" + state + '}';
    }
}
