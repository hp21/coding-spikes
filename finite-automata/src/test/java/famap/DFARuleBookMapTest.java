package famap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created User: Peter Horvath/u292148
 * Date: 2013.07.05. Time: 19:48
 */
public class DFARuleBookMapTest {

    private DFARuleBookMap ruleBook;

    @Before
    public void setUp() throws Exception {
        ruleBook = new DFARuleBookMap(Arrays.asList(new FARule("1", 'a', "2"), new FARule("1", 'b', "1"), new FARule("2", 'a', "2"), new FARule("2", 'b', "3"), new FARule("3", 'a', "3"), new FARule("3", 'b', "3")));
    }

    @Test
    public void test1() throws Exception {


        DFARuleBookMap ruleBook = new DFARuleBookMap(Arrays.asList(new FARule("1", 'a', "2"), new FARule("1", 'b', "1"), new FARule("2", 'a', "2"), new FARule("2", 'b', "3"), new FARule("3", 'a', "3"), new FARule("3", 'b', "3")));
        final String actual = ruleBook.nextState("1", 'a');
        assertThat(actual, equalTo("2"));


        final String actual1 = ruleBook.nextState("1", 'b');
        assertThat(actual1, equalTo("1"));

        final String actual2 = ruleBook.nextState("2", 'b');
        assertThat(actual2, equalTo("3"));

    }

    @Test
    public void test2() throws Exception {

        DFA dfa = new DFA("1", Arrays.asList("3"), ruleBook);
        final boolean actual = dfa.accepting();
        assertThat(actual, equalTo(false));


        dfa = new DFA("1", Arrays.asList("3"), ruleBook);
        dfa.readString("baaab");
        final boolean actual1 = dfa.accepting();
        assertThat(actual1, equalTo(true));

    }
}
