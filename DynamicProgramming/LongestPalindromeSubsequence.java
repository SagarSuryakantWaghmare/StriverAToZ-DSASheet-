public class LongestPalindromeSubsequence {
    public static String longestPalindromeSubsequence(String s1,String s2){
        int n1=s1.length();
        int n2=s2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                 dp[i][j]=1+dp[i-1][j-1];
               }
               else {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int i=n1;
        int j=n2;

        StringBuilder sb=new StringBuilder();
        while (i>0&&j>0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        // String s="bbbab";
        // int result = longestPalindromeSubsequence(s);
        // System.out.println("Length of Longest Palindromic Subsequence: " + result);
        // Output: 4
        // It should maintain the order of characters
        // For example, "bbbab" -> "bbbb" or "bab"
        // Generate all subsequnce and pick the longest one "Brute force approach"
        
        // Longest common subsequnce
        
        String s="bbabcbcab";
        String r="";
        for(int i=s.length()-1;i>=0;i--){
            r+=s.charAt(i);
        }
        String result = longestPalindromeSubsequence(s,r);
        System.out.println("Length of Longest Palindromic Subsequence: " + result);
    }
}