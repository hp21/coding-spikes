package famap;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created User: Peter Horvath/
 * Date: 2013.07.05. Time: 19:38
 */
public class DFARuleBookMap {

    final Map<String, Map<Character, String>> rules;

    public DFARuleBookMap(final List<FARule> ruleList) {
        this.rules = buildRules(ruleList);
    }

    public String nextState(String state, char character) {
        return rules.get(state).get(character);
    }

    private Map<String, Map<Character, String>> buildRules(List<FARule> ruleList) {
        final Map<String, Map<Character, String>> value = new HashMap<String, Map<Character, String>>();

        for (FARule rule : ruleList) {
            if (!value.containsKey(rule.getState())) {
                value.put(rule.getState(), new HashMap<Character, String>());
            }

            Map<Character, String> item = value.get(rule.getState());
            item.put(rule.getCharacter(), rule.getNextState());
        }

        return value;
    }
}
