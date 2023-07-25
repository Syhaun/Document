package PTA;
import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        int result = eval(expr);
        System.out.println(result);
    }

    private static int eval(String expr) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int num = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == expr.length() - 1 || !Character.isDigit(expr.charAt(i + 1))) {
                    numStack.push(num);
                    num = 0;
                }
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (opStack.peek() != '(') {
                    numStack.push(applyOp(opStack.pop(), numStack.pop(), numStack.pop()));
                }
                opStack.pop();
            } else if (isOperator(c)) {
                while (!opStack.isEmpty() && hasPrecedence(c, opStack.peek())) {
                    numStack.push(applyOp(opStack.pop(), numStack.pop(), numStack.pop()));
                }
                opStack.push(c);
            }
        }
        while (!opStack.isEmpty()) {
            numStack.push(applyOp(opStack.pop(), numStack.pop(), numStack.pop()));
        }
        return numStack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-');
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
            case '%':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot modulo by zero");
                }
                return a % b;
        }
        return 0;
    }
}

