import java.util.*;

public class BalancedParenthesis {
  public static boolean isBalanced(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        st.push(c);
      } else {
        if(st.isEmpty()){
          return false;
        }
        if (c == ']') {
          char t = st.peek();
          if (c == ']' && t == '[') {
            st.pop();
          }
        } else if (c == '}') {
          char t = st.peek();
          if (c == '}' && t == '{') {
            st.pop();
          }
        } else if (c == ')') {
          char t = st.peek();
          if (c == ')' && t == '(') {
            st.pop();
          }
        }

      }
    }
    return st.isEmpty();
  }

  public static void main(String[] args) {
    String s = "{[()]}[]";
    System.out.println(isBalanced(s));
  }
}