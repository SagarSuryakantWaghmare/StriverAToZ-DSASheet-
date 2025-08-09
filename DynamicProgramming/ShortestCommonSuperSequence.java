public class ShortestCommonSuperSequence {
    public static String shortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        // Build LCS table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        // Shortest common supersequence
        // Shortest supersequnence
        // "bleued"-all string which combines string 1 and string 2
        // length of string 6
        // shortest common supersequence=>n+m-len(lcs)
        // length=n+M-len(lcs) //shortest super sequence
        // How to find the string is the problem

        // We get the idea how to find the shortest super sequence
        // So we just make the dp as we make for the lcs in the other example
        // Now we go to get the string form teh given dp array

        // Step by step we get the string
        // brute and groot
        // etou and then we follow for other one's
        // etouorbg
        // gbrouote
        System.out.println("Shortest Common Super sequence is :" + shortestCommonSuperSequence(s1, s2));

    }
}
