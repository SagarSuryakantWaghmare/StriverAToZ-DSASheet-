import java.util.Arrays;

public class EditDistance {
    public static int minOp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // return helper(s1, s2, n - 1, m - 1);
        // int dp[][]=new int[n][m];
        // // Memoization way
        // for(int row[]:dp){
        // Arrays.fill(row, -1);
        // }
        // return MemRec(s1,s2,n-1,m-1,dp);
        // return tabOp(s1, s2);
        int curr[]=new int[m+1];
        int prev[]=new int [m+1];
        for (int j = 0; j <= m; j++) prev[j] = j;
        for(int i=1;i<=n;i++){
            curr[0] = i;
            for(int j=1;j<=m;j++){
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                curr[j]=prev[j-1];
               }
               else{
                 curr[j]=1+Math.min(prev[j], Math.min(prev[j-1], curr[j-1]));
               }
            }
            prev=curr.clone();
        }
        return prev[m];
    }

    public static int helper(String s1, String s2, int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (s1.charAt(i) == s2.charAt(j)) {
            i--;
            j--;
        }
        // we have to do three things
        // insert
        int insert = 1 + helper(s1, s2, i, j - 1);
        // delete
        int delete = 1 + helper(s1, s2, i - 1, j);
        // replace
        int replace = 1 + helper(s1, s2, i - 1, j - 1);
        return Math.min(insert, Math.min(delete, replace));
    }

    public static int MemRec(String s1, String s2, int i, int j, int dp[][]) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return MemRec(s1, s2, i - 1, j - 1, dp);
        }
        int insert = 1 + MemRec(s1, s2, i, j - 1, dp);
        int delete = 1 + MemRec(s1, s2, i - 1, j, dp);
        int replace = 1 + MemRec(s1, s2, i - 1, j - 1, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    // Tabulazation way
    public static int tabOp(String s, String t) {
        int n = s.length();
        int m = t.length();
        int s1 = s.length();
        int t1 = t.length();
        int dp[][] = new int[s1 + 1][t1 + 1];
        for(int i=0;i<t1;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<s1;i++){
            dp[i][0]=i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1+dp[i][j - 1];
                    int delete = 1+dp[i - 1][j - 1];
                    int replace = 1+dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[s1][t1];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        // We can do three operations in the given problem -insert,remove and replace
        // Edit always (m+n) max
        System.out.println("Minimum operations required for the making similar:" + minOp(s1, s2));
    }
}