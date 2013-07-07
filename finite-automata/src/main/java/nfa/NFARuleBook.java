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
    private final List<FARule> rules;

    public NFARuleBook(final List<FARule> rules) {
        this.rules = rules;
    }

    public Set<String> nextStates(Set<String> states, char character) {
        final HashSet<String> nextStates = new HashSet<String>();

        for (String state : states) {
            nextStates.addAll(followRulesFor(state, character));
        }

        return nextStates;
    }

    private Set<String> followRulesFor(String state, char character) {
        final HashSet<String> followStates = new HashSet<String>();

        for (FARule rule : findRuleFor(state, character)) {
            followStates.add(rule.follow());
        }

        return followStates;
    }

    private Set<FARule> findRuleFor(String state, char character) {
        final HashSet<FARule> matchingRules = new HashSet<FARule>();

        for (FARule rule : rules) {
            if (rule.appliesTo(state, character)) {
                matchingRules.add(rule);
            }
        }

        return matchingRules;
    }

}
