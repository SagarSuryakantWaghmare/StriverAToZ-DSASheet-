import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String s1,String s2,int idx1,int idx2){
        // common subsequence
        // powerset like 2^n
        // Brute force solution find all the subsequence and then
        // Get all the things properly
        // Search linearly
        // Compare all two subsequence and compare
        // so we are finding the in the recurrsion way:


        // Rules to write:Recurrsion
        /*
         * 1.Express with help of index (idx1,idx2)
         * 2.Explore possibility on that index
         * 3.Take the best
         */

        //  For this problem we used the express into 2 index
        // so we have to find the lcs
        // For both the index s1(0 to 2) and s2(0 to 2)
        if(idx1<0||idx2<0){
            return 0;
        }
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+longestCommonSubsequence(s1, s2, idx1-1, idx2-1);
        }
        return Math.max(longestCommonSubsequence(s1, s2, idx1-1, idx2), longestCommonSubsequence(s1, s2, idx1, idx2-1));

    }
    // Memoizatation way
    public static int longestCommonSubsequenceMem(String s1,String s2,int idx1,int idx2,int dp[][]){
       if(idx1<0||idx2<0){
        return 0;
       } 
       if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
       if(s1.charAt(idx1)==s2.charAt(idx2)){
        return 1+longestCommonSubsequenceMem(s1, s2, idx1-1, idx2-1, dp);

       }
       return dp[idx1][idx2]=Math.max(longestCommonSubsequenceMem(s1, s2, idx1-1, idx2, dp), longestCommonSubsequenceMem(s1, s2, idx1, idx2-1, dp));
    }
    // Tabulzation way
    public static int longestCommonSubsequenceTab(String s1,String s2){
        int n1=s1.length();
        int n2=s2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    // Space optimize code
    public static int longestCommonSubsequenceSpace(String s1,String s2){
        int n1=s1.length();
        int n2=s2.length();
        int []prev=new int[m+1];
        int []curr=new int[m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i)==s2.charAt(i)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j], curr[j-1]);
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        // Example usage
        String text1 = "acd";
        String text2 = "ced";
        // int n1=text1.length();
        // int n2=text2.length();
        // int[][]dp=new int[n1][n2];
        // for(int row[]:dp){
        //     Arrays.fill(row, -1);
        // }
        // int result = longestCommonSubsequence(text1, text2,text1.length()-1,text2.length()-1);
        // int result = longestCommonSubsequenceMem(text1, text2,n1-1,n2-1,dp);
        // int result = longestCommonSubsequenceTab(text1,text2);
        int result = longestCommonSubsequenceSpace(text1,text2);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}
