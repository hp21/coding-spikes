package famap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created User: Peter Horvath/hp21 Date: 2013.07.06. Time: 17:38
 */
public class StateFactory implements IStateFactory {

    private Map<String, State> cache;

    public StateFactory() {
        cache = new ConcurrentHashMap<String, State>();
    }

    /**
     * @param from
     * @return
     */
    @Override
    public State produce(String from) {

        if (cache.containsKey(from)) {
            return cache.get(from);
        }

        synchronized (cache) {
            if (!cache.containsKey(from)) {
                cache.put(from, new State(from));
            }

            return cache.get(from);
        }
    }
}
