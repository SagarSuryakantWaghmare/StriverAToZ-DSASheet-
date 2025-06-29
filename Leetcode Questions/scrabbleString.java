class Scramble {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        Boolean[][][] dp = new Boolean[n][n][n + 1];
        return isScrambleHelper(s1, s2, 0, 0, n, dp);
    }

    private boolean isScrambleHelper(String s1, String s2, int i1, int i2, int length, Boolean[][][] dp) {
        if (dp[i1][i2][length] != null) {
            return dp[i1][i2][length];
        }

        String substr1 = s1.substring(i1, i1 + length);
        String substr2 = s2.substring(i2, i2 + length);

        if (substr1.equals(substr2)) {
            dp[i1][i2][length] = true;
            return true;
        }

        int[] count = new int[26];
        for (int i = 0; i < length; i++) {
            count[s1.charAt(i1 + i) - 'a']++;
            count[s2.charAt(i2 + i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                dp[i1][i2][length] = false;
                return false;
            }
        }

        for (int i = 1; i < length; i++) {
            if (isScrambleHelper(s1, s2, i1, i2, i, dp) && isScrambleHelper(s1, s2, i1 + i, i2 + i, length - i, dp)) {
                dp[i1][i2][length] = true;
                return true;
            }
            if (isScrambleHelper(s1, s2, i1, i2 + length - i, i, dp) && isScrambleHelper(s1, s2, i1 + i, i2, length - i, dp)) {
                dp[i1][i2][length] = true;
                return true;
            }
        }

        dp[i1][i2][length] = false;
        return false;
    }

    public static void main(String[]args){
        String s="Ram";
        String r="mar";
        Scramble sc=new Scramble();
        boolean result = sc.isScramble(s, r);
        if(result){
            System.out.println("The strings are scramble of each other");
        } else {
            System.out.println("The strings are not scramble of each other");
        }
    }
}
