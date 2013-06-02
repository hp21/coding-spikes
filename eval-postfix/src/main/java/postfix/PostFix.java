package postfix;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 */
public class PostFix {

    final private Pattern pattern;

    public PostFix() {
        pattern = Pattern.compile("[+-]?\\d+");
    }

    public long eval(String expression) {

        final Stack<Long> stack = new Stack<Long>();

        final StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreTokens()) {
            final String token = tokenizer.nextToken();

            if (isOperator(token)) {
                final Long value2 = stack.pop();
                final Long value1 = stack.pop();
                Long result = compute(value1, value2, token);
                stack.push(result);
            } else if (isNumber(token)) {
                final Long value = Long.valueOf(token);
                stack.push(value);
            } else {
                throw new RuntimeException("Illegal symbol: " + token);
            }

        }

        if (stack.size() != 1) {
            throw new RuntimeException("Illage postfix expression: stack size must be 1");
        }

        return stack.pop();
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
