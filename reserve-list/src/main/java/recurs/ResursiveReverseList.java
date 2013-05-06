package recurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created Date: 2013.05.06. Time: 12:53
 */
public class ResursiveReverseList<T> {

    final List<?> list;

    public ResursiveReverseList(List<?> list) {
        this.list = list;
    }

    public List<?> reverse() {
        final List<Object> myList = new ArrayList<Object>();

        if (list.isEmpty()) {
            return myList;
        }

        final Iterator<?> iterator = list.iterator();

        reverse(iterator, myList);

        return myList;
    }

    private void reverse(Iterator<?> iterator, List<Object> pList) {

        if (iterator.hasNext()) {
            final Object next = iterator.next();
            reverse(iterator, pList);
            pList.add(next);
        }

    }
}
