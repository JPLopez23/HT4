import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public String convertToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('(', 0); // Paréntesis tienen la menor precedencia
        precedence.put('+', 1); // Suma
        precedence.put('-', 1); // Resta
        precedence.put('*', 2); // Multiplicación
        precedence.put('/', 2); // División

        for (char token : infixExpression.toCharArray()) {
            if (Character.isDigit(token)) {
                postfix.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(token)) {
                    postfix.append(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        for (char token : postfixExpression.toCharArray()) {
            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero.");
                        }
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
