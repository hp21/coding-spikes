package simplecalc;

/**
 * Created with IntelliJ IDEA. Date: 2013.05.08. Time: 8:51 To change this
 * template use File | Settings | File Templates.
 */
public class SimpleCalculator {

    private static String EOF = "EOF";

    private String nextChar;
    private String stringToParse;
    private int currentPosition;

    public SimpleCalculator() {
    }

    public int parse(String str) {

        currentPosition = 0;
        stringToParse = str.trim();
        nextChar = nextChar();
        int value = expression(nextChar);
        if (!nextChar.equals(EOF)) {
            throw new RuntimeException("Not EOF Char: " + nextChar + " near pos: " + currentPosition);
        }

        return value;
    }

    private int expression(String nc) {
        int value = 0;

        if (isDigit(nc) || "(".equals(nc)) {
            term(nc);

            while (arithOperation(nextChar)) {
                nextChar = nextChar();
                term(nextChar);
            }

           /* if (arithOperation(nextChar)) {
                nextChar = nextChar();
                term(nextChar);
            }*/
        } else {
            throw new RuntimeException("Illegal expression: " + nc);
        }

        return value;
    }

    private void term(String nc) {
        if (isDigit(nc)) {
            nextChar = nextChar();
        } else if ("(".equals(nc)) {
            nextChar = nextChar();
            term(nextChar);
            if (")".equals(nextChar)) {
                nextChar = nextChar();
            } else {
                throw new RuntimeException("Illegal term in parent: " + nextChar);
            }
        } else {
            throw new RuntimeException("Illegal term: " + nc);
        }

    }

    private String nextChar() {

        String ret;

        if (currentPosition < stringToParse.length()) {
            ret = stringToParse.substring(currentPosition, currentPosition + 1);
            currentPosition++;
        } else {
            ret = EOF;
        }
        return ret;
    }

    private boolean isDigit(String nc) {
        return Character.isDigit(nc.charAt(0));
    }

    private boolean arithOperation(String nextChar) {
        return "+".equals(nextChar) || "-".equals(nextChar);
    }

}
