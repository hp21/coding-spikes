package recurs;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Unit test for simple App.
 */
public class Test2 {

    private List<String> list;

    @Before
    public void setUp() {
        list = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7");
    }

    @Test
    public void test1() {

        final ResursiveReverseList resursiveReverseList = new ResursiveReverseList(list);

        final List<String> reverseList = (List<String>) resursiveReverseList.reverse();

        for (int i = 0; i < list.size(); i++) {
            Assert.assertThat(reverseList.get(i), CoreMatchers.equalTo(list.get(list.size() - i - 1)));
        }

        System.out.println("got: " + reverseList);

    }
}
