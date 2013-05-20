package fizzbuzz;

/**
 * See: http://content.codersdojo.org/code-kata-catalogue/fizz-buzz/
 * 
 */
public class FizzBuzz {

    public FizzBuzz() {
    }

    public String fizzBuzz(int value) {
        String retValue = String.valueOf(value);

        if (value % 3 == 0) {
            retValue = "fizz";
        }

        if (value % 5 == 0) {

            if ("fizz".equals(retValue)) {
                retValue += "buzz";
            } else {
                retValue = "buzz";
            }
        }

        return retValue;
    }
}
