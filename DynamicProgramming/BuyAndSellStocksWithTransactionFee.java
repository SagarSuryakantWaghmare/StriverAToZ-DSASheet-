import java.util.Arrays;

public class BuyAndSellStocksWithTransactionFee {
    public static int maxProfit(int prices[], int fee, int idx, int buy) {
        int n = prices.length;
        if (idx == n) {
            return 0;
        }
        int maxP = 0;
        if (buy == 1) {
            maxP = Math.max(-prices[idx] + maxProfit(prices, fee, idx + 1, 0),
                    0 + maxProfit(prices, fee, idx + 1, 1));
        } else {
            maxP = Math.max(prices[idx] - fee + maxProfit(prices, fee, idx + 1, 1),
                    maxProfit(prices, fee, idx + 1, 0));
        }
        return maxP;
    }

    // Memoization way
    public static int maxProfitMem(int prices[], int fee, int idx, int buy, int dp[][]) {
        if (idx == prices.length) {
            return 0;
        }
        if (dp[idx][buy] != -1)
            return dp[idx][buy];
        int maxP = 0;
        if (buy == 1) {
            maxP = Math.max(-prices[idx] + maxProfitMem(prices, fee, idx + 1, 0, dp),
                    0 + maxProfitMem(prices, fee, idx + 1, 1, dp));
        } else {
            maxP = Math.max(prices[idx] - fee + maxProfitMem(prices, fee, idx + 1, 1, dp),
                    0 + maxProfitMem(prices, fee, idx + 1, 0, dp));
        }
        return dp[idx][buy] = maxP;
    }

    // Tabulzation way
    public static int maxProfitTab(int prices[], int fee) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b <= 1; b++) {
                int maxP = 0;
                if (b == 1) {
                    maxP = Math.max(-prices[i] + dp[i+1][0],
                            0 + dp[i+1][1]);
                } else {
                    maxP = Math.max(prices[i] - fee +dp[i+1][1],
                            0 +dp[i+1][0]);
                }
                 dp[i][b] = maxP;
            }
        }
        return dp[0][1];
    }

    public static int maxProfitSpace(int prices[],int fee){
        int n=prices.length;
        int curr[]=new int[2];
        int after[]=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                int maxP=0;
                if(b==1){
                    maxP=Math.max(-prices[i]+curr[0],
                    0+curr[1]);
                }
                else{
                    maxP=Math.max(prices[i]-fee+curr[1],
                    0+curr[0]);
                }
                curr[b]=maxP;
            }
            after=curr.clone();
        }
        return after[1];
    }
    public static void main(String[] args) {
        // Best time to sell stock with transaction fee
        int prices[] = { 1, 3, 2, 8, 4, 9 };
        // int prices[]={1,2,3};
        int fee = 2;
        // int fee=1;
        // System.out.println(maxProfit(prices, fee,0,1));
        int dp[][] = new int[prices.length][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        // System.out.println(maxProfitMem(prices,fee,0,1,dp));
        // System.out.println(maxProfitTab(prices, fee));
        System.out.println(maxProfitSpace(prices, fee));

    }
}
