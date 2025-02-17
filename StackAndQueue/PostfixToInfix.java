import java.util.Stack;

public class PostfixToInfix {
    public static String postfixToInfix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(Character.toString(ch));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String ans = "(" + t2 + ch + t1 + ")";
                st.push(ans);
            }
        }
        return st.pop(); 
    }

    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        System.out.println("Infix Expression: " + postfixToInfix(s));
    }
}
