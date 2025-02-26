import java.util.Stack;

public class removeKDigits {
    //  4 3 1 2 2 1 
    // k=3
    // 4
    // 3--remove 4
    // 1--remove 3
    // 2
    // 2--remove 1
    // 1
    // Edge Cases
    // k==n
    // So return "0"
    // 00100
    // k=2
    // 0
    // 0
    // 1

    // 1 2 3 4 5 6
    // k=3
    // 1
    // 2
    // 3
    // 4
    // 5
    // 6
    //123 -remove the last elements
    public static String RemoveKDigits(String s, int k){
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for (int i = 0; i <n; i++) {
            while (!st.empty() && k > 0 && (st.peek() - '0') > (s.charAt(i) - '0')) {
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }
        while (k>0) {
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse();
        // Remove leading zeros
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();
        

    }

    public static void main(String[] args) {
        String s="4310221";
        int k=3;
        System.out.println(RemoveKDigits(s,k));
    }
}