package ls0;

import com.google.common.base.Objects;

/**
 * Created by hp21 on 2013.12.26..
 */
public class ListElement {

    private int value;

    private ListElement next;

    public ListElement(int value) {
        this.value = value;
    }

    public ListElement(int value, ListElement next) {
        this.value = value;
        this.next = next;
    }

    public ListElement next() {
        return getNext();
    }

    public int value() {
        return value;
    }

    public boolean isLastElement() {
        return next() == null;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", value).add("next", next == null ? "null" : "not null (" + next().value() + ")")
                .toString();
    }
}
