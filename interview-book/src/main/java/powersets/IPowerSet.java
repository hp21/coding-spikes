package powersets;

import java.util.List;
import java.util.Set;

/**
 * Created by HP21 on 2016.07.22..
 */
public interface IPowerSet<T> {

    Set<List<T>> powerSet(List<T> mySet);
}
