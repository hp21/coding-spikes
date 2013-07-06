package famap;

/**
 * Created User: Peter Horvath/ Date: 2013.07.06. Time: 13:01
 */
public class State {

    private String state;

    State(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return state;
    }

    @Override
    public String toString() {
        return "State{" + "state='" + state + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        State state1 = (State) o;

        if (!state.equals(state1.state))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
}
