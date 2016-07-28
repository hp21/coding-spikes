package spike.partorder.revlist;

/**
 * Created with IntelliJ IDEA.
 * Date: 2013.04.05.
 * Time: 9:40
 */
public class ReverseListManager {

    public <T> Item<T> reverse(Item<T> list) {

        if (list == null || list.next() == null) {
            return list;
        }


        for (Item<T> item = list, nexItem = list.next(); nexItem != null; nexItem=nexItem.next(), item = item.next()){


        }

            return list;
    }

}


