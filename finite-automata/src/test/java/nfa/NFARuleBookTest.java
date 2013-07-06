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

        final HashSet<String> currentSet = new HashSet<String>();
        currentSet.add("1");
        final Set<String> actual = ruleBook.nextStates(currentSet, 'b');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("2"), equalTo(true));

        //TODO: Finish

/*
        #<struct NFARulebook rules=[…]>
        >> rulebook.next_states(Set[1], 'b')
                => #<Set: {1, 2}>
        >> rulebook.next_states(Set[1, 2], 'a')
        => #<Set: {1, 3}>
        >> rulebook.next_states(Set[1, 3], 'b')
        => #<Set: {1, 2, 4}>
*/

/*
        final String actual1 = ruleBook.nextStates("1", 'b');
        assertThat(actual1, equalTo("1"));

        final String actual2 = ruleBook.nextStates("2", 'b');
        assertThat(actual2, equalTo("3"));
*/

    }

    @Test
    @Ignore
    public void test2() throws Exception {

       /* DFA dfa = new DFA("1", Arrays.asList("3"), ruleBook);
        final boolean actual = dfa.accepting();
        assertThat(actual, equalTo(false));


        dfa = new DFA("1", Arrays.asList("3"), ruleBook);
        dfa.readString("baaab");
        final boolean actual1 = dfa.accepting();
        assertThat(actual1, equalTo(true));*/

    }
}
