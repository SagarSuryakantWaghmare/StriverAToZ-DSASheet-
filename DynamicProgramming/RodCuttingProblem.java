import java.util.Arrays;

public class RodCuttingProblem {
    public static int cutRod(int[] price, int n, int idx) {
        int rodLength = idx + 1;
        if (idx == 0) {
            return (n / rodLength) * price[0];
        }
        int notPick = cutRod(price, n, idx - 1);
        int pick = Integer.MIN_VALUE;
        if (rodLength <= n) {
            pick = price[idx] + cutRod(price, n - rodLength, idx);
        }
        return Math.max(notPick, pick);
    }

    // Memoization way
    public static int cutRodMem(int price[], int n, int idx, int dp[][]) {
        int rodLength = idx + 1;
        if (idx == 0) {
            return (n / rodLength) * price[0];
        }
        if (dp[idx][n] != -1)
            return dp[idx][n];
        int notPick = cutRodMem(price, n, idx - 1, dp);
        int pick = Integer.MIN_VALUE;
        if (rodLength <= n) {
            pick = price[idx] + cutRodMem(price, n - rodLength, idx, dp);
        }
        return dp[idx][n] = Math.max(notPick, pick);
    }

    // Tabulization way
    public static int cutRodTab(int price[], int n) {
        int length = price.length;
        int dp[][] = new int[length][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = (j / 1) * price[0];
        }
        for (int i = 1; i < length; i++) {
            int rodLength = i + 1;
            for (int j = 0; j <= n; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MIN_VALUE;
                if (rodLength <= j) {
                    pick = price[i] + dp[i][j - rodLength];
                }
                dp[i][j] = Math.max(notPick, pick);
            }
        }
        return dp[length - 1][n];
    }

    public static int cutRodSpace(int price[], int n) {
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            prev[j] = j / 1 * price[0];
        }
        // 1d array
        for (int i = 1; i < price.length; i++) {
            int rodLength = i + 1;
            for (int j = 0; j <= n; j++) {
                int notPick = prev[j];
                int pick = Integer.MIN_VALUE;
                if (rodLength <= j) {
                    pick = price[i] + curr[j - rodLength];
                }
                curr[j]=Math.max(notPick, pick);
            }
            prev=curr.clone();
        }
        return prev[n];
    }

    public static void main(String[] args) {
        // Rod cutting problem
        int price[] = { 2, 5, 7, 8, 10 };
        // Rod length
        int n = 5;
        // int length = price.length;
        // Maximum revenue
        // int dp[][] = new int[length][n + 1];
        // for (int i = 0; i < length; i++) {
        // Arrays.fill(dp[i], -1);
        // }

        // int maxRevenue = cutRodMem(price, n, length - 1, dp);

        // Tabulzation way
        // int maxRevenue = cutRodTab(price, n);

        // Space optimzation way
        int maxRevenue = cutRodSpace(price, n);
        System.out.println("Maximum revenue for rod of length " + n + " is: " + maxRevenue);
    }
}