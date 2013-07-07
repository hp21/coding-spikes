package nfa;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import fa.FARule;

/**
 * Created User: Peter Horvath/ Date: 2013.07.05. Time: 19:38
 */
public class NFARuleBook {

    /**
     * NFA Machines rules
     */
    private final Collection<FARule> rules;

    public NFARuleBook(final Collection<FARule> rules) {
        this.rules = rules;
    }

    public Set<String> nextStates(Set<String> states, char character) {
        final HashSet<String> nextStates = new HashSet<String>();

        for (String state : states) {
            nextStates.addAll(followRulesFor(state, character));
        }

        return nextStates;
    }

    public Set<String> followFreeMoves(Set<String> states) {

        final Set<String> moreStates = nextStates(states, FARule.NIL);

        if (Sets.difference(moreStates, states).isEmpty()) {
            return states;
        }
        else {
            states.addAll(moreStates);
            return followFreeMoves(states);
        }
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
