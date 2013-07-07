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

        Set<String> actual = ruleBook.nextStates(SetCreator.create("1"), 'b');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("2"), equalTo(true));

        actual = ruleBook.nextStates(SetCreator.create("1", "2"), 'a');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("3"), equalTo(true));

        actual = ruleBook.nextStates(SetCreator.create("1", "3"), 'b');
        assertThat(actual.contains("1"), equalTo(true));
        assertThat(actual.contains("2"), equalTo(true));
        assertThat(actual.contains("4"), equalTo(true));
    }

    @Test
    public void test2() throws Exception {

        NFA nfa = new NFA(SetCreator.create("1"), SetCreator.create("4"), ruleBook);
        nfa.readString("bbbbb");

        boolean actual = nfa.accepting();
        assertThat(actual, equalTo(true));

        nfa = new NFA(SetCreator.create("1", "2", "4"), SetCreator.create("4"), ruleBook);
        nfa.readString("bbbbb");

        actual = nfa.accepting();
        assertThat(actual, equalTo(true));

        nfa = new NFA(SetCreator.create("1", "2", "4"), SetCreator.create("4"), ruleBook);
        nfa.readString("bbabb");

        actual = nfa.accepting();
        assertThat(actual, equalTo(false));
    }
}
