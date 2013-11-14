package slist;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import loop.LoopNode;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.11.06. Time: 12:34
 */
public class ListManipulatorTest {

    private LoopNode node1;
    private LoopNode node2;
    private LoopNode node3;
    private LoopNode node4;
    private LoopNode node5;
    private IListManipulator listManipulator;

    @Before
    public void setUp() {
        listManipulator = new ListManipulator();

        node1 = new LoopNode(1);
        node2 = new LoopNode(2);
        node3 = new LoopNode(3);
        node4 = new LoopNode(4);
        node5 = new LoopNode(5);
    }

    @Test
    public void insertIntoEmpty() throws Exception {

        final LoopNode actual = listManipulator.insert(null, 3);
        assertThat(actual.getValue(), equalTo(3));
    }

    @Test
    @Ignore
    public void insertIntoListStart() throws Exception {

        final LoopNode actual = listManipulator.insert(node4, 1);

        assertThat(actual, notNullValue());
        assertThat(actual.next(), sameInstance(node4));
        assertThat(actual.getValue(), equalTo(1));
    }

}
