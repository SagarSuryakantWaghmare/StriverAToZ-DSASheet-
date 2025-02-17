import java.util.Stack;

public class PostfixToPrefix {
    public static String prefix(String s){
        Stack<String> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }
            else{
                String t1=st.pop();
                String t2=st.pop();
                String a=ch+t2+t1;
                st.push(a);
            }


        }
        return st.pop();
    }
    public static void main(String[] args) {
        String s="AB-DE+F*/";
        System.out.println("Prefix"+prefix(s));
    }
}
