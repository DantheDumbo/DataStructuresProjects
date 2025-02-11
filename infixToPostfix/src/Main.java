import java.util.*;

public class Main {

    public static String infixToPostfix(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder answer = new StringBuilder();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                answer.append(c);
            } else if (isOperator(c)) {
                while (!s.isEmpty() && !isOpenParenthesis(s.peek()) && hasHigherOrEqualPrecedence(s.peek(), c)) {
                    answer.append(s.pop());
                }
                s.push(c);
            } else if (isOpenParenthesis(c)) {
                s.push(c);
            } else if (isClosedParenthesis(c)) {
                while (!s.isEmpty() && !isOpenParenthesis(s.peek())) {
                    answer.append(s.pop());
                }
                if (!s.isEmpty()) {
                    s.pop(); // Remove '('
                }
            }
        }

        while (!s.isEmpty()) {
            answer.append(s.pop());
        }

        return answer.toString();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean isOpenParenthesis(char c) {
        return c == '(';
    }

    public static boolean isClosedParenthesis(char c) {
        return c == ')';
    }

    public static boolean hasHigherOrEqualPrecedence(char a, char b) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        return precedence.getOrDefault(a, 0) > precedence.getOrDefault(b, 0) ||
                (precedence.getOrDefault(a, 0) == precedence.getOrDefault(b, 0) && a != '(');
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b+c+d"));  // Expected: ab+c+d+
        System.out.println(infixToPostfix("a-b/c"));    // Expected: abc/-
        System.out.println(infixToPostfix("(a+b)/c"));  // Expected: ab+c/
        System.out.println(infixToPostfix("a-b*c*(d/f)")); // Expected: abc*df/*-
        System.out.println(infixToPostfix("((a+a)*b/c+d)/(e*(f-g)/(h+((a+a)*b/c+d)/(e(f-g)/(h+i))*q))*((((a+a)*b/c+d)/(e*(f-g)/(h+((a+a)*b/c+d)/(e*(f-g)/(h+i))*q))+a)*b/c+d)/(e*(f-g)/(h+((a+a)*b/c+d)/(e*(f-g)/(h+i))*q))")); // Expected: abc*df/*-
    }
}
