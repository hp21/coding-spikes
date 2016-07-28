package factorial;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.05.07. Time: 13:32 To
 * change this template use File | Settings | File Templates.
 */
public class FactorialRecurse implements IFactorial {

    public FactorialRecurse() {
    }

    @Override
    public long fact(long n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
