package fa;

import java.util.List;

/**
 * Created User: Peter Horvath/ Date: 2013.07.05. Time: 19:38
 */
public class DFARuleBook {

    final List<FARule> rules;

    public DFARuleBook(final List<FARule> rules) {
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
