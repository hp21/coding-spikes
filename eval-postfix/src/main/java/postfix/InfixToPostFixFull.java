package postfix;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Date: 2013.06.02. Time: 18:07
 */
public class InfixToPostFixFull {

    private static final Pattern VARIABLE = Pattern.compile("[a-z]+");
    private final Pattern pattern;

    public InfixToPostFixFull() {
        pattern = Pattern.compile("[+-]?\\d+||[a-z]+]");
    }

    public String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder("");

        final Stack<String> stack = new Stack<String>();

        for (String token : expression.split(" ")) {
            if (isNumber(token)) {
                result.append(token).append(" ");
            } else if (isOperator(token)) {
                if (stack.isEmpty()) {
                    stack.push(token);
                } else {
                    while (!stack.isEmpty() && isHigherPrecedence(stack.peek(), token)) {
                        result.append(stack.pop()).append(" ");
                    }

                    stack.push(token);
                }
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();

    }

    private boolean isHigherPrecedence(String peek, String token) {
        boolean result = false;

        if (isDivideOperator(peek) || isMultiplyOperator(peek)) {
            if (isPlusOperator(token) || isMisunOperator(token)) {
                result = true;
            }
        } else if (isPlusOperator(peek) || isMisunOperator(peek)) {
            if (isPlusOperator(token) || isMisunOperator(token)) {
                result = true;
            }
        }

        return result;
    }

    private boolean isOperator(String token) {
        return isPlusOperator(token) || isMisunOperator(token) || isMultiplyOperator(token) || isDivideOperator(token);
    }

    private boolean isNumber(String token) {
        return pattern.matcher(token).matches() || VARIABLE.matcher(token).matches();
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

    private boolean isLeftParen(String token) {
        return "(".equals(token);
    }

    private boolean isRightParen(String token) {
        return ")".equals(token);
    }

}
