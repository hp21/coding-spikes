package codechef.cyclic.list;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import codechef.cycl.list.CyclicList;

import com.google.common.collect.Lists;

/**
 * User: P Horvath Date: 2013.04.14. Time: 13:31
 */
public class CyclicListTest {

    private CyclicList tester;

    @Before
    public void setUp() {
        tester = new CyclicList();
    }

    @Test(expected = NullPointerException.class)
    public void testNulls() {

        List<?> aList = null;
        List<?> bList = Lists.newArrayList("1");
        tester.checkLists(aList, bList);

    }

    @Test(expected = NullPointerException.class)
    public void testNulls1() {

        List<?> bList = null;
        List<?> aList = Lists.newArrayList("1");
        tester.checkLists(aList, bList);

    }

    @Test()
    public void testSameListSize() {

        List<?> aList = Lists.newArrayList("2", 1);
        List<?> bList = Lists.newArrayList("1");
        boolean actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(false));

        aList = Lists.newArrayList("2");
        bList = Lists.newArrayList("1", 432);
        tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(false));
    }

    @Test()
    public void testDifferentElementTypes() {

        List<?> aList = Lists.newArrayList(1, 2);
        List<?> bList = Lists.newArrayList("1", "2");
        boolean actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(false));
    }

    @Test()
    public void testSimpleCase() {

        List<?> aList = Lists.newArrayList(0, 1, 2, 3, 4);
        List<?> bList = Lists.newArrayList(1, 2, 3, 4, 0);
        boolean actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 3, 4);
        bList = Lists.newArrayList(2, 3, 4, 0, 1);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 3, 4);
        bList = Lists.newArrayList(3, 4, 0, 1, 2);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 3, 4);
        bList = Lists.newArrayList(4, 0, 1, 2, 3);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 3, 4);
        bList = Lists.newArrayList(0, 1, 2, 3, 4);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

    }

    @Test()
    public void testCompoundCase() {

        List<?> aList = Lists.newArrayList(0, 1, 2, 2, 3, 4);
        List<?> bList = Lists.newArrayList(1, 2, 2, 3, 4, 0);
        boolean actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 2, 3, 4);
        bList = Lists.newArrayList(1, 2, 2, 3, 0, 4);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(false));

        aList = Lists.newArrayList(0, 1, 2, 2, 3, 4);
        bList = Lists.newArrayList(3, 4, 0, 1, 2, 2);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 2, 3, 4);
        bList = Lists.newArrayList(4, 0, 1, 2, 2, 3);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

        aList = Lists.newArrayList(0, 1, 2, 2, 3, 4);
        bList = Lists.newArrayList(0, 1, 2, 2, 3, 4);
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(true));

    }

    @Test()
    public void testAlmostOkCase() {

        List<?> aList = Lists.newArrayList(0, 1, 2, 3, 4);
        List<?> bList = Lists.newArrayList(1, 2, 3, 4, 10);
        boolean actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(false));

        aList = Lists.newArrayList(0, 1, 2, 3, 4);
        bList = Lists.newArrayList(2, 3, 4, 0, "1");
        actual = tester.checkLists(aList, bList);
        Assert.assertThat(actual, CoreMatchers.equalTo(false));
    }
}
