public class MinimumInsertionsToMakeStringPalindrome {

    public static int insertionsToMakePalindrome(String s,String r) {
        // If i reverse the string then we can opertions=len(s) max length
        // n-longest palindromic subsequence
        int n1=s.length();
        int n2=r.length();
        int dp[][]=new int[n1+1][n2+1];
        int max=0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
               if(s.charAt(i-1)==r.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
               }
               else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
               max=Math.max(max, dp[i][j]);
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return n1-dp[n1][n2];    
    }

    public static void main(String[] args) {
        // Min insertions to make string palindrome
        String s="bbabcbcab";
        String r="";
        for(int i=s.length()-1;i>=0;i--){
            r+=s.charAt(i);
        }
        System.out.println("Minimum Insertions To Make String Palindrome:" + insertionsToMakePalindrome(s,r));
    }
}