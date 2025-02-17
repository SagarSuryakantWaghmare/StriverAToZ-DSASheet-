import java.util.Stack;

public class InfixToPostFix {
    public static int priority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    public static String postFix(String s) {
        String ans = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, add to result
            if (Character.isLetterOrDigit(ch)) {
                ans += ch;
            }
            // If '(', push to stack
            else if (ch == '(') {
                st.push(ch);
            }
            // If ')', pop and add to result until '(' is found
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop(); // Remove '('
            }
            else {
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                    ans += st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-c)";
        System.out.println("PostFix String: " + postFix(s));
    }
}
