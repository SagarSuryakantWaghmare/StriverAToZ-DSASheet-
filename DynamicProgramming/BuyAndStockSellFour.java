import java.util.Arrays;

public class BuyAndStockSellFour {
    // Recursion way
    public static int maxProfit(int prices[], int cal, int idx, int buy) {
        if (idx == prices.length) {
            return 0;
        }
        if (cal == 0) {
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + maxProfit(prices, cal, idx + 1, 0),
                    0 + maxProfit(prices, cal, idx + 1, 1));
        } else {
            profit = Math.max(prices[idx] + maxProfit(prices, cal - 1, idx + 1, 1),
                    0 + maxProfit(prices, cal, idx + 1, 0));
        }
        return profit;
    }

    // Tabulation way
    public static int maxProfitMem(int prices[], int k, int idx, int buy, int dp[][][]) {
        if (idx == prices.length) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[idx][buy][k] != -1)
            return dp[idx][buy][k];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + maxProfitMem(prices, k, idx + 1, 0, dp),
                    0 + maxProfitMem(prices, k, idx + 1, 1, dp));
        } else {
            profit = Math.max(prices[idx] + maxProfitMem(prices, k - 1, idx + 1, 1, dp),
                    0 + maxProfitMem(prices, k, idx + 1, 0, dp));
        }
        return dp[idx][buy][k] = profit;
    }

    public static void main(String[] args) {
        int prices[] = { 3, 2, 6, 5, 0, 3 };
        int k = 3;
        // index =0,buy=0/1,cal=k;
        int n = prices.length;
        // System.out.println(maxProfit(prices,k,0,1));
        // int dp[][][]=new int[n+1][2][k+1];
        // for(int row[][]:dp){
        // for(int col[]:row){
        // Arrays.fill(col, -1);
        // }
        // }
        // System.out.println(maxProfitMem(prices,k,0,1,dp));

        // Tabulation way
        // int dp[][][] = new int[n + 1][2][k + 1];
        // for(int i=0;i<=n;i++){
        // for(int b=0;b<=1;b++){
        // dp[i][b][0]=0;
        // }
        // }
        // for (int idx = n - 1; idx >= 0; idx--) {
        // for (int b = 0; b <= 1; b++) {
        // for (int c = 1; c <= k; c++) {
        // int profit = 0;
        // if (b == 1) {
        // profit = Math.max(-prices[idx] + dp[idx + 1][0][c],
        // 0 + dp[idx + 1][1][c]);
        // } else {
        // profit = Math.max(prices[idx] + dp[idx + 1][1][c - 1],
        // 0 + dp[idx + 1][0][c]);
        // }
        // dp[idx][b][c] = profit;
        // }
        // }
        // }
        // System.out.println(dp[0][1][k]);
        System.out.println(maxProfitSpaceOpt(prices, k));
    }

    public static int maxProfitSpaceOpt(int[] prices, int k) {
        int n = prices.length;
        int next[][] = new int[2][k + 1];
        int curr[][] = new int[2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 1; c <= k; c++) {
                    int profit = 0;
                    if (b == 1) {
                        profit = Math.max(-prices[i] + next[0][c],
                                0 + next[1][c]);
                    } else {
                        profit = Math.max(prices[i] + next[1][c - 1],
                                0 + next[0][c]);
                    }
                    curr[b][c] = profit;
                }
            }
            next = curr;
            curr = new int[2][k + 1];
        }
        return next[1][k];
    }

}
