import java.util.*;

public class PrefixToInfix {

    public static String prefixToInfix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(Character.toString(ch));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String a="("+t1+ch+t2+")";
                st.push(a);
            }

        }
        return st.pop();
    }

    public static void main(String[] args) {
        String s = "*+PQ-MN";
        System.out.println("Infix Expression: " + prefixToInfix(s));
    }
}
