public class knapsackProblem {
    public static int knapsack(int[] weight, int val[], int idx, int bag) {
        // Base case
        if (idx == 0) {
            if (weight[0] <= bag) {
                return val[0];
            } else {
                return 0;
            }
        }
        int notTake = 0 + knapsack(weight, val, idx - 1, bag);
        int take = Integer.MIN_VALUE;
        if (weight[idx] <= bag) {
            take = val[idx] + knapsack(weight, val, idx - 1, bag - weight[idx]);
        }
        return Math.max(take, notTake);
    }

    public static int knapsack(int[] weight, int val[], int idx, int bag, int dp[]) {
        // Base case
        if (idx == 0) {
            if (weight[0] <= bag) {
                return val[0];
            } else {
                return 0;
            }
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int notTake = 0 + knapsack(weight, val, idx - 1, bag);
        int take = Integer.MIN_VALUE;
        if (weight[idx] <= bag) {
            take = val[idx] + knapsack(weight, val, idx - 1, bag - weight[idx]);

        }
        return dp[idx] = Math.max(take, notTake);
    }

    // Tabulazation code
    // Step first base case
    // we have to make the int dp[][]=new int[n][w];
    // Int and wt
    public static int knapsack(int[] weight, int val[], int bag) {
        int n = weight.length;
        // Creating a dp array
        int dp[][]=new int[n][bag+1];
        // Starting with the base case
        for(int w=0;w<=bag;w++){
            if(weight[0]<=w){
                dp[0][w]=val[0];
            }
            else{
                dp[0][w]=0;
            }
        }
        // Now we have to fill the dp array
        for(int idx=1;idx<n;idx++){
            for(int w=0;w<=bag;w++){
                int notTake = 0 + dp[idx-1][w];
                int take = Integer.MIN_VALUE;
                if(weight[idx]<=w){
                    take = val[idx] + dp[idx-1][w-weight[idx]];
                }
                dp[idx][w] = Math.max(take, notTake);
            }
        }
        return dp[n-1][bag];

    }

    // Space optimization
    public static int knapsackSpace(int[] weight, int val[], int bag) {
        int n = weight.length;
        // Creating a dp array
        int prev[] = new int[bag + 1];
        // Starting with the base case
        for (int w = 0; w <= bag; w++) {
            if (weight[0] <= w) {
                prev[w] = val[0];
            } else {
                prev[w] = 0;
            }
        }
        // Now we have to fill the dp array
        for (int idx = 1; idx < n; idx++) {
            int curr[] = new int[bag + 1];
            for (int w = 0; w <= bag; w++) {
                int notTake = 0 + prev[w];
                int take = Integer.MIN_VALUE;
                if (weight[idx] <= w) {
                    take = val[idx] + prev[w - weight[idx]];
                }
                curr[w] = Math.max(take, notTake);
            }
            prev = curr; 
        }
        return prev[bag];
    }


    public static void main(String[] args) {
        int weight[] = { 3, 2, 5 };
        int val[] = { 30, 40, 60 };
        // So we get the idx of idx-1
        // int n = weight.length - 1;
        // System.out.println(knapsack(weight,val,n,6));

        // Memoization way
        // int dp[] = new int[n + 1];
        // for (int i = 0; i <= n; i++) {
        // dp[i] = -1;
        // }
        // System.out.println(knapsack(weight, val, n, 6, dp));

        // System.out.println(knapsack(weight, val, 6));
        System.out.println(knapsackSpace(weight, val, 6));

    }
}
