package mintree;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.11.02. Time: 22:58 To
 * change this template use File | Settings | File Templates.
 */
public class MaxOperation implements IOperation<Integer, Integer> {


    @Override
    public Integer operation(Integer inp, Integer inp1) {

        return inp > inp1 ? inp : inp1;
    }
}
