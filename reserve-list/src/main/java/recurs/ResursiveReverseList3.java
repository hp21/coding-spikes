package recurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created Date: 2013.05.06. Time: 12:53
 */
public class ResursiveReverseList3<T> {

    final private List<?> list;

    public ResursiveReverseList3(List<?> list) {
        this.list = list;
    }

    public List<?> reverse() {

        final Iterator<?> iterator = list.iterator();
        final List<Object> reverseList = reverse(iterator);
        return reverseList;
    }

    private List<Object> reverse(Iterator<?> iterator) {
        List ret;

        if (noMoreElement(iterator)) {
            ret = new ArrayList<Object>(); // stop condition
        } else {
            final Object next = iterator.next();
            ret = reverse(iterator);
            ret.add(next);
        }

        return ret;
    }

    private boolean noMoreElement(Iterator<?> iterator) {
        return !iterator.hasNext();
    }
}
