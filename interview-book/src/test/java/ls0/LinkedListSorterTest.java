package ls0;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2013.12.26..
 */
public class LinkedListSorterTest {

    private LinkedListSorter sorter;

    @Before
    public void setUp() throws Exception {
        sorter = new LinkedListSorter();
    }

    @Test
    public void testWithNull() throws Exception {

        ListElement head = null;
        final ListElement actual = sorter.sortList(head);

        assertThat(actual, nullValue());
    }

    @Test
    public void testWithOne() throws Exception {

        ListElement head = new ListElement(3, null);
        final ListElement actual = sorter.sortList(head);

        assertThat(actual, notNullValue());
        assertThat(actual, sameInstance(head));
    }

    @Test
    public void testWithTwo() throws Exception {

        // increment list

        ListElement h10 = new ListElement(10, null);
        ListElement head = new ListElement(3, h10);
        ListElement actual = sorter.sortList(head);

        assertThat(actual, notNullValue());
        assertThat(actual.value(), equalTo(3));
        assertThat(actual.next().value(), equalTo(10));

        // decrement list
        ListElement h3 = new ListElement(3, null);
        head = new ListElement(11, h3);

        actual = sorter.sortList(head);

        assertThat(actual, notNullValue());
        assertThat(actual.value(), equalTo(3));
        assertThat(actual.next().value(), equalTo(11));

    }

    @Test
    public void testWithThree() throws Exception {

        // increment list
        ListElement last = new ListElement(22, null);
        ListElement h10 = new ListElement(10, last);
        ListElement head = new ListElement(3, h10);

        ListElement actual = sorter.sortList(head);

        assertThat(actual, notNullValue());
        assertThat(actual.value(), equalTo(3));
        assertThat(actual.next().value(), equalTo(10));
        assertThat(actual.next().next().value(), equalTo(22));

        // decrement list

        ListElement h11 = new ListElement(11, null);
        ListElement h20 = new ListElement(20, h11);
        head = new ListElement(30, h20);

        actual = sorter.sortList(head);

        assertThat(actual, notNullValue());
        assertThat(actual.value(), equalTo(11));
        assertThat(actual.next().value(), equalTo(20));
        assertThat(actual.next().next().value(), equalTo(30));

        // random list

        ListElement h200 = new ListElement(200, null);
        ListElement h100 = new ListElement(100, h200);
        ListElement h300 = new ListElement(300, h100);

        head = h300;

        actual = sorter.sortList(head);

        assertThat(actual, notNullValue());
        assertThat(actual.value(), equalTo(100));
        assertThat(actual.next().value(), equalTo(200));
        assertThat(actual.next().next().value(), equalTo(300));

    }
}
