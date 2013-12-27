package ls0;

/**
 * Created by hp21 on 2013.12.26..
 */
public class LinkedListSorter {

    public LinkedListSorter() {
    }

    public ListElement sortList(ListElement head) {
        if (head == null) {
            return null;
        }

        if (head.next() == null) {
            return head;
        }

        ListElement sortedSubList = sortList(head.next());

        final ListElement result = insertIntoPosition(head, sortedSubList);
        return result;
    }

    private ListElement insertIntoPosition(final ListElement element, final ListElement sortedSubList) {
        ListElement result = sortedSubList;

        ListElement prev = null;
        ListElement follow = null;

        for (ListElement myElement = result; myElement != null; myElement = myElement.next()) {
            if (element.value() < myElement.value()) {
                follow = myElement;
                break;
            }

            prev = myElement;
        }

        if (prev != null) {
            // not 1st element in list
            prev.setNext(element);
        } else {
            // 1st element in list
            result = element;
        }

        element.setNext(follow);
        return result;
    }
}
