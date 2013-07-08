package nfastate;

import com.google.common.collect.Sets;
import famap.State;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

    public Set<State> nextStates(Set<State> states, char character) {
        final HashSet<State> nextStates = new HashSet<State>();

        for (State state : states) {
            nextStates.addAll(followRulesFor(state, character));
        }

        return nextStates;
    }

    public Set<State> followFreeMoves(Set<State> states) {

        final Set<State> moreStates = nextStates(states, FARule.NIL);

        if (Sets.difference(moreStates, states).isEmpty()) {
            return states;
        }
        else {
            states.addAll(moreStates);
            return followFreeMoves(states);
        }
    }


    private Set<State> followRulesFor(State state, char character) {
        final HashSet<State> followStates = new HashSet<State>();

        for (FARule rule : findRuleFor(state, character)) {
            followStates.add(rule.follow());
        }

        return followStates;
    }

    private Set<FARule> findRuleFor(State state, char character) {
        final HashSet<FARule> matchingRules = new HashSet<FARule>();

        for (FARule rule : rules) {
            if (rule.appliesTo(state, character)) {
                matchingRules.add(rule);
            }
        }

        return matchingRules;
    }

}
