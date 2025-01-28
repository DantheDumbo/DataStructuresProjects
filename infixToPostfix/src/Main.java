import java.util.*;

public class Main {

    public static String infixToPostfix(String str) {
        Stack<Character> s = new Stack<>();
        String answer = "";

        char[] chars = str.toCharArray();
        
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                answer += c;
            } else if (isOperator(c)) {
                while (!s.isEmpty() && !isOpenParenthesis(s.peek()) && hasHigherOrEqualPrecidence(s.peek(), c)) {
                    answer += s.pop();
                }
                s.push(c);
            } else if (isOpenParenthesis(c)) {
                s.push(c);
            } else if (isClosedParenthesis(c)) {
                while (!s.isEmpty() && !isOpenParenthesis(s.peek())) {
                    answer += s.pop();
                }
                if (!s.isEmpty() && isOpenParenthesis(s.peek())) {
                    s.pop();
                }
            }
        }

        while (!s.isEmpty()) {
            answer += s.pop();
        }

        return answer;
    }

    public static boolean isOperator(char c) {
        Set<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        return (operators.contains(c));
    }

    public static boolean isOpenParenthesis(char c) {
        return (c == 40);
    }

    public static boolean isClosedParenthesis(char c) {
        return (c == 41);
    }

    public static boolean hasHigherOrEqualPrecidence(char a, char b) {
        Map<Character, Set<Character>> precedence = new HashMap<>();

        Set<Character> add = new HashSet<>();
        add.add('-');

        Set<Character> subtract = new HashSet<>();
        subtract.add('+');

        Set<Character> multiply = new HashSet<>();
        multiply.add('+');
        multiply.add('-');
        multiply.add('/');

        Set<Character> divide = new HashSet<>();
        divide.add('+');
        divide.add('-');
        divide.add('*');

        precedence.put('+', add);
        precedence.put('-', subtract);
        precedence.put('*', multiply);
        precedence.put('/', divide);

        return precedence.get(a).contains(b);
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b+c+d"));
        System.out.println(infixToPostfix("a-b/c"));
        System.out.println(infixToPostfix("(a+b)/c"));
        System.out.println(infixToPostfix("a-b*c*(d/f)"));
        System.out.println(infixToPostfix("((a+a)*b/c+d)/(e*(f-g)/(h + ((a+a)*b/c+d)/(e(f-g)/(h + I))*q))*((((a+a)*b/c+d)/(e*(f - g)/(h + ((a+a)*b/c+d)/(e*(f - g)/(h + I))*q))+a)*b/c+d)/(e*(f - g)/(h + ((a+a)*b/c+d)/(e*(f - g)/(h + I))*q))"));
    }
}