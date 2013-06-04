package exp;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Date: 2013.06.04. Time: 19:26
 */
public class ExpressionParser {

    private static String EOF = "EOF";
    private final String expression;
    private final List<String> tokenList;
    private final Pattern pattern;

    private String currentToken;

    public ExpressionParser(String expression) {
        pattern = Pattern.compile("[+-]?\\d+");
        this.expression = expression;
        tokenList = initTokens(expression);
    }

    private List<String> initTokens(String expression) {
        final ArrayList<String> myTokenList = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreTokens()) {
            myTokenList.add(tokenizer.nextToken());
        }

        return myTokenList;
    }

    public long parse() {
        nextToken();
        long value = term();

        while (isPlusOperator(currentToken) || isMisunOperator(currentToken)) {
            String operation = currentToken;
            nextToken();
            final long myValue = term();
            value = compute(value, myValue, operation);
        }

        return value;
    }

    private long term() {
        long value = factor();

        while (isMultiplyOperator(currentToken) || isDivideOperator(currentToken)) {
            String operation = currentToken;
            nextToken();
            final long myValue = factor();
            value = compute(value, myValue, operation);
        }

        return value;
    }

    private long factor() {
        long value;

        if (isNumber(currentToken)) {
            value = Long.valueOf(currentToken);
            nextToken();
        } else {
            throw new RuntimeException("factor: Number expteced, got: " + currentToken);
        }

        return value;
    }

    protected String nextToken() {
        String value;

        if ("EOF".equals(currentToken)) {
            throw new RuntimeException("nextToken called after EOF");
        }

        if (tokenList.isEmpty()) {
            value = currentToken;
            currentToken = value;
        } else {
            value = tokenList.remove(0);
            currentToken = value;
        }

        return value;
    }

    private Long compute(long value1, long value2, String token) {
        long result;

        if (isPlusOperator(token)) {
            result = value1 + value2;
        } else if (isMisunOperator(token)) {
            result = value1 - value2;
        } else if (isMultiplyOperator(token)) {
            result = value1 * value2;
        } else if (isDivideOperator(token)) {
            result = value1 / value2;
        } else {
            throw new RuntimeException("Illegal operation: " + token);
        }

        return result;
    }

    private boolean isOperator(String token) {
        return isPlusOperator(token) || isMisunOperator(token) || isMultiplyOperator(token) || isDivideOperator(token);
    }

    private boolean isNumber(String token) {
        return pattern.matcher(token).matches();
    }

    private boolean isPlusOperator(String token) {
        return "+".equals(token);
    }

    private boolean isMisunOperator(String token) {
        return "-".equals(token);
    }

    private boolean isMultiplyOperator(String token) {
        return "*".equals(token);
    }

    private boolean isDivideOperator(String token) {
        return "/".equals(token);
    }

}
