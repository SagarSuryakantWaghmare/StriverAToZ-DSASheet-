import java.util.Arrays;

public class WildCardMatching {
    // Rules to write recurrence
    // Express all in the form of (i,j)
    // explore comparisons
    // Out of all compersions,if anyone can you return true

    // Recursion tc->exponential and sc->O(n+m)
    public static boolean isMatch(String s, String t, int l1, int l2) {
        // Base case
        // Both string exhausted
        if (l1 < 0 && l2 < 0) {
            return true;
        }
        // First get exhaushted
        if (l1 < 0 && l2 >= 0) {
            return false;
        }
        // second get exhaushted
        if (l2 < 0 && l1 >= 0) {
            for (int k = 0; k <= l1; k++) {
                if (s.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        // There are two conditions matched or not matched

        if (s.charAt(l1) == t.charAt(l2) || s.charAt(l1) == '?') {
            return isMatch(s, t, l1 - 1, l2 - 1);
        }
        if (s.charAt(l1) == '*') {
            return isMatch(s, t, l1 - 1, l2) || isMatch(s, t, l1, l2 - 1);
        }
        return false;
    }

    public static boolean isMatchMem(String s, String t, int i, int j, boolean[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0 && j <= 0)
            return false;
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (s.charAt(i) != '*') {
                    return false;
                }
            }
        }
        if (dp[i][j] != false)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j) || s.charAt(i) == '?') {
            return dp[i][j] = isMatch(s, t, i - 1, j - 1);
        }
        if (s.charAt(i) == '*') {
            return dp[i][j] = isMatch(s, t, i - 1, j) || isMatch(s, t, i, j - 1);
        }
        return dp[i][j] = false;
    }

    public static boolean wildcardMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(j - 1);
                char sc = s.charAt(i - 1);

                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' matches zero characters or one/more characters
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        // Wildcard matching
        /*
         * ?-> matches with single character
         * *-> matches with any number of characters or none(zero characters)
         * s1="?ay"
         * s2="ray"
         * return true
         * 
         * s1="ab*cd";
         * s2="abdefcd"
         * return true
         */
        String s1 = "ab*cd";
        String s2 = "abdefcd";
        // System.out.println(isMatch(s1, s2,s1.length()-1,s2.length()-1));
        // int l1=s1.length();
        // int l2=s2.length();
        // boolean dp[][]=new boolean[l1][l2];
        // for(boolean row[]:dp){
        // Arrays.fill(row, false);
        // }
        // System.out.println(isMatchMem(s1, s2,s1.length()-1,s2.length()-1,dp));
        System.out.println("Wildcard string matching possible:" + wildcardMatch(s1, s2));
    }

}
