import java.util.Arrays;

public class BestTimeToBuyAndSellStockThree {
    public static int maxProfit(int[] prices, int idx, int buy, int cap) {
        int n = prices.length;
        if (cap == 0)
            return 0;
        if (idx == n)
            return 0;
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + maxProfit(prices, idx + 1, 0, cap),
                    0 + maxProfit(prices, idx + 1, 1, cap));
        } else {
            profit = Math.max(prices[idx] + maxProfit(prices, idx + 1, 1, cap - 1),
                    0 + maxProfit(prices, idx + 1, 0, cap));
        }
        return profit;
    }

    // Memoization way
    public static int maxProfitMem(int[] prices, int idx, int buy, int cap, int dp[][][]) {
        int n = prices.length;
        if (idx == n)
            return 0;
        if (cap == 0)
            return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[idx]+maxProfitMem(prices, idx+1, 0, cap, dp),
            0+maxProfitMem(prices, idx+1, 1, cap, dp));
        }    
        else{
            profit=Math.max(prices[idx]+maxProfitMem(prices, idx+1, 1, cap-1, dp),
            0+maxProfitMem(prices, idx+1, 0, cap, dp));
        }
        return dp[idx][buy][cap]=profit;
    }

    // Tabulazation way
    public static int maxProfitTab(int prices[]){
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];
        // base case for the cap 0
        // cap 0 then dp put 0
        for(int i=0;i<=n;i++){
            for(int b=0;b<=1;b++){
                dp[i][b][0]=0;
            }
        }
        // Compute the calculations for the max profit
        for(int i=n-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                for(int c=1;c<=2;c++){
                    int profit=0;
                    if(b==1){
                        profit=Math.max(-prices[i]+dp[i+1][0][c],
                        0+dp[i+1][1][c]);
                    }
                    else{
                        profit=Math.max(prices[i]+dp[i+1][1][c-1],
                        0+dp[i+1][0][c]);
                    }
                    dp[i][b][c]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        // Output: 7
        System.out.println("Best Time to Buy and Sell Stock III");
        // System.out.println(maxProfit(prices,0,1,2));
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for (int row[][] : dp) {
            for (int col[] : row) {
                Arrays.fill(col, -1);
            }
        }
        // System.out.println(dp[3][1][2]);
        // System.out.println(maxProfitMem(prices, 0, 1, 2, dp));
        System.out.println(maxProfitTab(prices));
    }
}
