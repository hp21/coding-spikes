package fa;

import java.util.Collection;
import java.util.List;

/**
 * Created User: Peter Horvath/ Date: 2013.07.05. Time: 19:38
 */
public class DFARuleBook {

    private final Collection<FARule> rules;

    public DFARuleBook(final Collection<FARule> rules) {
        this.rules = rules;
    }

    public String nextState(String state, char character) {
        return findRuleFor(state, character).follow();
    }

    public FARule findRuleFor(String state, char character) {
        for (FARule rule : rules) {
            if (rule.appliesTo(state, character)) {
                return rule;
            }
        }

        return null;
    }

}
