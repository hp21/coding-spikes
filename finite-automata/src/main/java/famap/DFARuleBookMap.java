package famap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created User: Peter Horvath/ Date: 2013.07.05. Time: 19:38
 */
public class DFARuleBookMap {

    final Map<State, Map<Character, State>> rules;

    public DFARuleBookMap(final List<FARule> ruleList) {
        this.rules = buildRules(ruleList);
    }

    public State nextState(State state, char character) {
        return rules.get(state).get(character);
    }

    private Map<State, Map<Character, State>> buildRules(List<FARule> ruleList) {
        final Map<State, Map<Character, State>> value = new HashMap<State, Map<Character, State>>();

        for (FARule rule : ruleList) {
            if (!value.containsKey(rule.getState())) {
                value.put(rule.getState(), new HashMap<Character, State>());
            }

            Map<Character, State> item = value.get(rule.getState());
            item.put(rule.getCharacter(), rule.getNextState());
        }

        return value;
    }
}
