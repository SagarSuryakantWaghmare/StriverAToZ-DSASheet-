import java.util.Arrays;

public class unboundedKnapsack {
    // Recursion
    public static int unboundedKnapsack(int weights[], int values[], int capacity, int idx) {
        if (idx == 0) {
            if (weights[0] <= capacity) {
                // We can fill the knapsack with as many of this item as possible
                return (capacity / weights[0]) * values[0];
            } else {
                return 0;
            }

        }
        int notPick = unboundedKnapsack(weights, values, capacity, idx - 1);
        int pick = Integer.MIN_VALUE;
        if (weights[idx] <= capacity) {
            pick = values[idx] + unboundedKnapsack(weights, values, capacity - weights[idx], idx);
        }

        return Math.max(notPick, pick);
    }

    // Mememoization way
    public static int unboundedKnapsackMem(int weights[], int values[], int capacity, int idx, int dp[][]) {
        int n = weights.length;
        if (idx == 0) {
            if (weights[idx] <= capacity) {
                return capacity / weights[0] * values[0];
            } else {
                return 0;
            }
        }
        if (dp[idx][capacity] != -1)
            return dp[idx][capacity];
        // Traversing the recursion
        int notPick = unboundedKnapsackMem(weights, values, capacity, idx - 1, dp);
        int pick = Integer.MIN_VALUE;
        if (weights[idx] <= capacity) {
            pick = values[idx] + unboundedKnapsackMem(weights, values, capacity - weights[idx], idx, dp);
        }
        return dp[idx][capacity] = Math.max(pick, notPick);
    }

    public static int unboundedKnapsackTab(int weights[], int values[], int capacity) {
        int n = weights.length;
        int dp[][] = new int[n][capacity + 1];
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = (c / weights[0]) * values[0];
            }
        }
        // Filling all dp by other using the for loops
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MIN_VALUE;
                if (weights[i] <= j) {
                    pick = values[i] + dp[i][j - weights[i]];
                }
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][capacity];
    }

    public static int unboundedKnapsackSpace(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int prev[] = new int[capacity + 1];

        // Base case initialization for item 0
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                prev[c] = (c / weights[0]) * values[0];
            }
        }

        // Iterating over the rest of the items
        for (int i = 1; i < n; i++) {
            int[] curr = new int[capacity + 1];
            for (int cap = 0; cap <= capacity; cap++) {
                int notPick = prev[cap];
                int pick = Integer.MIN_VALUE;
                if (weights[i] <= cap) {
                    pick = values[i] + curr[cap - weights[i]];
                }
                curr[cap] = Math.max(pick, notPick);
            }
            prev = curr; // Move current results to prev for next iteration
        }
        return prev[capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3 };
        int[] values = { 10, 15, 40 };
        int capacity = 7;
        // System.out.println("Maximum value in Knapsack = " +
        // unboundedKnapsack(weights, values, capacity, weights.length - 1));
        // int n = weights.length;
        // int dp[][] = new int[n][capacity + 1];
        // for(int row[]:dp){
        // Arrays.fill(row, -1);
        // }
        // System.out.println("Maximum value in Knapsack = " +
        // unboundedKnapsackMem(weights, values, capacity, weights.length - 1,dp));

        // Tabulazation way:
        // System.out.println("Maximum value in Knapsack = " +
        // unboundedKnapsackTab(weights, values, capacity));

        // Space optimization way
        System.out.println("Maximum value in Knapsack = " + unboundedKnapsackSpace(weights, values, capacity));
    }
}