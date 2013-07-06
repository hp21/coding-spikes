package nfa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fa.FARule;

/**
 * Created User: Peter Horvath/ Date: 2013.07.05. Time: 19:38
 */
public class NFARuleBook {

    /**
     * NFA Machines rules
     */
    final List<FARule> rules;

    public NFARuleBook(final List<FARule> rules) {
        this.rules = rules;
    }

    public Set<String> nextStates(Set<String> states, char character) {
        final HashSet<String> values = new HashSet<String>();

        for (String state : states) {
            values.addAll(followRulesFor(state, character));
        }

        return values;
    }

    public Set<String> followRulesFor(String state, char character) {
        final HashSet<String> followSet = new HashSet<String>();

        for (FARule rule : findRuleFor(state, character)) {
            followSet.add(rule.follow());
        }

        return followSet;
    }

    public Set<FARule> findRuleFor(String state, char character) {
        final HashSet<FARule> value = new HashSet<FARule>();

        for (FARule rule : rules) {
            if (rule.appliesTo(state, character)) {
                value.add(rule);
            }
        }

        return value;
    }

}
