import java.util.Arrays;

public class coinChangeTwo {
    public static int coinChange(int[] coins, int amount, int idx) {
        if (amount == 0)
            return 1; // base case: valid combination
        if (idx < 0 || amount < 0)
            return 0; // base case: no valid way

        // Not pick current coin
        int notPick = coinChange(coins, amount, idx - 1);
        // Pick current coin (unlimited times)
        int pick = coinChange(coins, amount - coins[idx], idx);

        return pick + notPick;
    }

    public static int coinChangeMem(int[] coins, int target, int idx, int dp[][]) {
        if (idx == 0)
            return 1;
        if (idx < 0 || target < 0)
            return 0;
        if (dp[idx][target] != -1)
            return dp[idx][target];
        int notPick = coinChangeMem(coins, target, idx - 1, dp);
        int pick = coinChangeMem(coins, target - coins[idx], idx, dp);
        return dp[idx][target] = notPick + pick;
    }

    public static int coinChangeTab(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];

        // Base case: Only using the first coin
        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1; // Only one way to form multiples of coins[0]
        }

        for (int ind = 1; ind < n; ind++) {
            for (int t = 0; t <= target; t++) {
                int notPick = dp[ind - 1][t];
                int pick = 0;
                if (coins[ind] <= t)
                    pick = dp[ind][t - coins[ind]];
                dp[ind][t] = pick + notPick;
            }
        }

        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 5;
        int n = coins.length;
        // System.out.println("Total Number of ways to make amount: " +
        // coinChange(coins, amount, coins.length - 1));
        // int dp[][]=new int[n][amount+1];
        // for(int row[]:dp){
        // Arrays.fill(row, -1);
        // }
        // System.out.println("Total Number of ways to make amount: " +
        // coinChangeMem(coins, amount, coins.length - 1,dp));

        System.out.println("Total Number of ways to make amount: " + coinChangeTab(coins, amount));

    }
}
