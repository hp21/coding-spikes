package nfa;

import fa.DFA;
import fa.FARule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created User: Peter Horvath/u292148
 * Date: 2013.07.05. Time: 19:48
 */
public class NFARuleBookTest {

    private NFARuleBook ruleBook;

    @Before
    public void setUp() throws Exception {
        ruleBook = new NFARuleBook(Arrays.asList(new FARule("1", 'a', "1"), new FARule("1", 'b', "1"), new FARule("1", 'b', "2"), new FARule("2",
                'a', "3"), new FARule("2", 'b', "3"), new FARule("3", 'a', "4"), new FARule("3", 'b', "4")));
    }

    @Test
    public void test1() throws Exception {


        NFARuleBook ruleBook = new NFARuleBook(Arrays.asList(new FARule("1", 'a', "1"), new FARule("1", 'b', "1"), new FARule("1", 'b', "2"),
                new FARule("2", 'a', "3"), new FARule("2", 'b', "3"), new FARule("3", 'a', "4"), new FARule("3", 'b', "4")));

        Set<String> currentSet = new HashSet<String>();
        currentSet.add("1");
        Set<String> actual = ruleBook.nextStates(currentSet, 'b');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("2"), equalTo(true));


        currentSet = new HashSet<String>();
        currentSet.add("1");
        currentSet.add("2");

        actual = ruleBook.nextStates(currentSet, 'a');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("3"), equalTo(true));

        currentSet = new HashSet<String>();
        currentSet.add("1");
        currentSet.add("3");
        actual = ruleBook.nextStates(currentSet, 'b');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("2"), equalTo(true));
        assertThat(actual.contains("4"), equalTo(true));

    }

    @Test
    public void test2() throws Exception {

        Set<String> startStates = new HashSet<String>();
        startStates.add("1");

        Set<String> acceptStates = new HashSet<String>();
        acceptStates.add("4");


        NFA nfa = new NFA(startStates, acceptStates, ruleBook);
        nfa.readString("bbbbb");

        final boolean actual = nfa.accepting();
        assertThat(actual, equalTo(true));


      /*  dfa = new DFA("1", Arrays.asList("3"), ruleBook);
        dfa.readString("baaab");
        final boolean actual1 = dfa.accepting();
        assertThat(actual1, equalTo(true));*/

    }
}
