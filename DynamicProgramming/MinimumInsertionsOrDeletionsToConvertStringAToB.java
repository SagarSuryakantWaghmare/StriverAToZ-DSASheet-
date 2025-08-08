public class MinimumInsertionsOrDeletionsToConvertStringAToB {
    public static int minOperation(String s,String t){
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);;
                }
            }
        }
        return n+m-2*dp[n][m];
    }

    public static void main(String[] args) {
        // Min operations to convert string 1 to string 2
        // string s->"abcd" and str2->"arc"
        // Max operations->n+m length of both
        // What can i don't touch
        // So abcd -> 2 deletions
        // So anc -> insertions
        // So most common subsequence is lcs
        // Deletions->n-len(lcs)
        // Insertions->m-len(lcs)

        // So total calculations is n+m-2(len(lcs))
        String s = "abcd";
        String t = "arc";
        System.out.println("Minimum Operations required for making same:" + minOperation(s, t));

    }
}