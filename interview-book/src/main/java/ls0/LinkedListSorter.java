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

        ListElement sorted;

        if (head.value() <= sortedSubList.value()) {
            sorted = head;
        } else {
            sorted = insertIntoPosition(head, sortedSubList);
        }

        return sorted;
    }

    private ListElement insertIntoPosition(ListElement element, ListElement sortedSubList) {

        ListElement prev = null;
        ListElement follow = null;

        for (ListElement myElement = sortedSubList; myElement != null; myElement = myElement.next()) {
            if (element.value() < myElement.value()) {
                follow = myElement;
                break;
            }

            prev = myElement;
        }

        if (prev != null) {
            prev.setNext(element);
        } else {
            sortedSubList.setNext(element); // beginning of list
        }

        element.setNext(follow);
        return sortedSubList;
    }
}
