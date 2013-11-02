package mintree;

/**
 * User: hp21 Date: 2013.11.02. Time: 22:51
 */
public interface IOperation<RESULT, INPUT> {

    public RESULT operation(INPUT inp,INPUT inp1);

}
