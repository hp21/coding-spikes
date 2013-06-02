package postfix;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import tree.Node;

/**
 * Date: 2013.06.02. Time: 12:52
 */
public class BuildTreePostFix {

    private final Pattern pattern;

    public BuildTreePostFix() {
        pattern = Pattern.compile("[+-]?\\d+");
    }

    public Node<String> buildTree(String expression) {
        final Stack<Node<String>> stack = new Stack<Node<String>>();

        final StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreTokens()) {
            final String token = tokenizer.nextToken();

            if (isOperator(token)) {
                Node<String> operatorNode = new Node<String>(token);
                final Node<String> value2 = stack.pop();
                final Node<String> value1 = stack.pop();
                operatorNode.setLeft(value1);
                operatorNode.setRight(value2);
                stack.push(operatorNode);
            } else if (isNumber(token)) {
                stack.push(new Node<String>(token));
            } else {
                throw new RuntimeException("Illegal symbol: " + token);
            }

        }

        if (stack.size() != 1) {
            throw new RuntimeException("Illage postfix expression: stack size must be 1");
        }

        return stack.pop();
    }

    public long evaluate(Node<String> node) {

        long result;

        final String nodeData = node.getData();
        final boolean operator = isOperator(nodeData);

        if (operator) {
            long leftValue = evaluate(node.getLeft());
            long rightValue = evaluate(node.getRight());
            result = compule(nodeData, leftValue, rightValue);
        } else if (isNumber(nodeData)) {
            result = Long.valueOf(nodeData);
        } else {
            throw new RuntimeException("Illegal token in node: " + node);
        }

        return result;

    }

    private long compule(String operator, long leftValue, long rightValue) {
        long value = 0;

        if (isPlusOperator(operator)) {
            value = leftValue + rightValue;
        } else if (isMisunOperator(operator)) {
            value = leftValue - rightValue;
        } else if (isMultiplyOperator(operator)) {
            value = leftValue * rightValue;
        } else if (isDivideOperator(operator)) {
            value = leftValue / rightValue;
        } else {
            throw new RuntimeException("Illegal operator: " + operator);
        }

        return value;

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
