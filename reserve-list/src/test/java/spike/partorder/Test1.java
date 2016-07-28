package spike.partorder;


import spike.partorder.revlist.Item;
import com.google.common.collect.Lists;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class Test1 {

    private Item<Load> list;
    private List<Item<Load>> itemList;

    @Before
    public void setUp() {
        final Item<Load> item1 = new Item<Load>(new Load(1L, "1"));
        final Item<Load> item2 = new Item<Load>(new Load(2L, "2"));
        final Item<Load> item3 = new Item<Load>(new Load(3L, "3"));
        final Item<Load> item4 = new Item<Load>(new Load(4L, "4"));
        final Item<Load> item5 = new Item<Load>(new Load(5L, "5"));

        item1.setNext(item2);
        item2.setNext(item3);
        item3.setNext(item4);

        list = item1;

        itemList = Lists.newArrayList(item1, item2, item3, item4, item5);
    }


    @Test
    public void test1() {
        int i = 0;
        for (Item<Load> item = list; item != null; item = item.next(), i++) {
            Assert.assertThat(item.getObj().getId().equals(itemList.get(i).getObj().getId()), CoreMatchers.equalTo(true));
        }


    }
}