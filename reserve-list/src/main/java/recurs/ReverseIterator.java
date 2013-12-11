package recurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hp21 on 2013.12.11.
 * 
 */
public class ReverseIterator<E> implements Iterator<E> {

    private final List<E> reverseCollection;
    private final Iterator<E> reverseIterator;

    public ReverseIterator(Collection<E> collection) {
        reverseCollection = reverse(collection.iterator());
        reverseIterator = reverseCollection.iterator();
    }

    private List<E> reverse(Iterator<E> iterator) {
        List<E> ret;

        if (!iterator.hasNext()) {
            ret = new ArrayList<E>(); // stop condition
        } else {
            final E next = iterator.next();
            ret = reverse(iterator);
            ret.add(next);
        }

        return ret;
    }

    @Override
    public boolean hasNext() {
        return reverseIterator.hasNext();
    }

    @Override
    public E next() {
        return reverseIterator.next();
    }

    @Override
    public void remove() {
        reverseIterator.remove();
    }
}
