public class LongestCommonSubstring {
    public static String longestCommonSubstring(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int maxLen = 0;
        int endIndex = 0; // end index of substring in 'a'

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i; 
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return a.substring(endIndex - maxLen, endIndex);
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "zcdemf";
        System.out.println("Longest Common Substring: " + longestCommonSubstring(str1, str2));
    }
}
