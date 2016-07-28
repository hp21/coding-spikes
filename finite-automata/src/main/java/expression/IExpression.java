package expression;

import java.util.Map;

/**
 * Created by hp21 on 2016.01.15..
 */
public interface IExpression {


    String inspect();

    boolean isReducible();

    IExpression reduce(Map<String, IExpression> environment);


}
