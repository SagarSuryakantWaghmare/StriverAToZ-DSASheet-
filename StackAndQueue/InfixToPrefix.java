import java.util.*;

public class InfixToPrefix {
    public static String reverse(String s) {
        char[] charArray = s.toCharArray();
        int low = 0, high = charArray.length - 1;
        
        while (low < high) { 
            char temp = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = temp;
            low++;
            high--;
        }
        return new String(charArray);
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String preFix(String s) {
        String ans = "";
        Stack<Character> st = new Stack<>();
        
        s = reverse(s);
        
        // Replace '(' with ')' and vice versa
        StringBuilder modified = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                modified.append(')');
            } else if (ch == ')') {
                modified.append('(');
            } else {
                modified.append(ch);
            }
        }
        s = modified.toString();
        
        // Convert to postfix
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                ans += ch;
            } 
            else if (ch == '(') {
                st.push(ch);
            } 
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();
            } 
            else { // Operator encountered
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                    ans += st.pop();
                }
                st.push(ch);
            }
        }

        // Pop all remaining operators
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        // Reverse final postfix to get prefix
        return reverse(ans);
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-c)";
        System.out.println("Prefix Expression: " + preFix(s));
    }
}
