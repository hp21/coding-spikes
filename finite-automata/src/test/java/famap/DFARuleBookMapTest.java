package famap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Created User: Peter Horvath/u292148 Date: 2013.07.05. Time: 19:48
 */
public class DFARuleBookMapTest {

    private DFARuleBookMap ruleBook;

    @Before
    public void setUp() throws Exception {
        ruleBook = new DFARuleBookMap(Arrays.asList(new FARule("1", 'a', "2"), new FARule("1", 'b', "1"), new FARule("2", 'a', "2"),
                new FARule("2", 'b', "3"), new FARule("3", 'a', "3"), new FARule("3", 'b', "3")));
    }

    @Test
    public void test1() throws Exception {

        DFARuleBookMap ruleBook = new DFARuleBookMap(Arrays.asList(new FARule("1", 'a', "2"), new FARule("1", 'b', "1"), new FARule("2",
                'a', "2"), new FARule("2", 'b', "3"), new FARule("3", 'a', "3"), new FARule("3", 'b', "3")));
        final State actual = ruleBook.nextState(new State("1"), 'a');
        assertThat(actual, equalTo(new State("2")));

        final State actual1 = ruleBook.nextState(new State("1"), 'b');
        assertThat(actual1.getStateCode(), equalTo("1"));

        final State actual2 = ruleBook.nextState(new State("2"), 'b');
        assertThat(actual2.getStateCode(), equalTo("3"));

    }

    @Test
    public void test2() throws Exception {

        DFA dfa = new DFA(new State("1"), Arrays.asList(new State("3")), ruleBook);
        final boolean actual = dfa.accepting();
        assertThat(actual, equalTo(false));

        dfa = new DFA(new State("1"), Arrays.asList(new State("3")), ruleBook);
        dfa.readString("baaab");
        final boolean actual1 = dfa.accepting();
        assertThat(actual1, equalTo(true));

    }
}
