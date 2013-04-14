package codechef.revlist;

/**
 * Created with IntelliJ IDEA.
 * User: u292148
 * Date: 2013.04.05.
 * Time: 9:43
 * To change this template use File | Settings | File Templates.
 */
public class Item<T> {

    private Item<T> next;

    private T obj;

    public Item(T obj) {
        this.obj = obj;
    }

    public Item<T> next() {
        return next;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Item{next=" + next + ", obj=" + obj + '}';
    }
}
