package pda;

/**
 * Created User: Peter Horvath/ Date: 2013.07.06. Time: 13:01
 */
public class PDAState {

    private String state;

    PDAState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PDAState pdaState = (PDAState) o;

        if (state != null ? !state.equals(pdaState.state) : pdaState.state != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PDAState{" + "state='" + state + '\'' + '}';
    }

}
