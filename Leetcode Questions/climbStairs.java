class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5; // example
        System.out.println("Ways to climb stairs: " + s.climbStairs(n));
    }

    public int climbStairs(int n) {
        // tabulazation
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(n, dp);

        // Space optimized
        // if(n<=1){
        //     return n;
        // }
        // int first=1;
        // int second=2;
        // for(int i=3;i<=n;i++){
        //     int third=second+first;
        //     first=second;
        //     second=third;
        // }
        // return second;
    }

    public static int climb(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
