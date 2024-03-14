import java.util.Stack;

public class ExpressionConverterImpl implements ExpressionConverter {

    @Override
    public String toPostfix(String infixExpression) {
        return infixToPostfix(infixExpression);
    }

    private String infixToPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    // Invalid expression
                    throw new IllegalArgumentException("Invalid expression");
                } else {
                    stack.pop();
                }
            } else { // an operator is encountered
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    if(stack.peek() == '(') {
                        throw new IllegalArgumentException("Invalid expression");
                    }
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if(stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid expression");
            }
            output.append(stack.pop());
        }
        return output.toString();
    }

    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
