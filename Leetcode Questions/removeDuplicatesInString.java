public class removeDuplicatesInString {
     public static String removeDuplicateLetters(String s) {
        int last[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        char[]stk=new char[26];
        boolean[]vis=new boolean[26];
        int top=-1;
        for(int i=0;i<n;i++){
            char cur=s.charAt(i);
            if(!vis[cur-'a']){
                while(top>=0&&stk[top]>cur&&last[stk[top]-'a']>i){
                    vis[stk[top--]-'a']=false;
                }
                stk[++top]=cur;
                vis[cur-'a']=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=top;i++){
            sb.append(stk[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "aabbccddeeffgghh";
        System.out.println(str);
        System.out.println("After removing the duplicates");
        String s= removeDuplicateLetters(str);
        System.out.println(s);

    }
}