import java.util.Arrays;

public class DistinctSubsequence {
    public static int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        // return count(n1-1,n2-1,s,t);
        // int dp[][]=new int[n1+1][n2+1];
        // for(int row[]:dp){
        // Arrays.fill(row,-1);
        // }
        // return countMem(n1-1,n2-2,s,t,dp);
        return countTab(s, t);
    }

    // Recurrsion way
    public static int count(int idx1, int idx2, String s, String t) {
        if (idx2 < 0) {
            return 1;
        }
        if (idx1 < 0) {
            return 0;
        }
        if (s.charAt(idx1) == t.charAt(idx2)) {
            return count(idx1 - 1, idx2 - 1, s, t) + count(idx1 - 1, idx2, s, t);
        }
        return count(idx1 - 1, idx2, s, t);
    }

    // Memoization way
    public static int countMem(int i, int j, String s, String t, int dp[][]) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = countMem(i - 1, j - 1, s, t, dp) + countMem(i - 1, j, s, t, dp);
        }
        return dp[i][j] = countMem(i - 1, j, s, t, dp);
    }

    // Tabulazation way
    public static int countTab(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }
}
