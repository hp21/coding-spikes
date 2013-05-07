package recurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created Date: 2013.05.06. Time: 12:53
 */
public class ResursiveReverseList2<T> {

    final List<?> list;

    public ResursiveReverseList2(List<?> list) {
        this.list = list;
    }

    public List<?> reverse() {

        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        final Iterator<?> iterator = list.iterator();
        final List<Object> reverseList = reverse(iterator);
        return reverseList;
    }

    private  List<Object> reverse(Iterator<?> iterator) {

        final ArrayList<Object> objects = new ArrayList<Object>();

        if (iterator.hasNext()) {
            final Object next = iterator.next();
            objects.addAll(reverse(iterator));
            objects.add(next);
        }

        return objects;
    }
}
