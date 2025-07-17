import java.util.*;

public class TriangleStartingToEndingPoint {
    // Recursion way
    public static int minPath(ArrayList<ArrayList<Integer>> ls, int i, int j) {
        int n = ls.size();
        if (i == n - 1)
            return ls.get(n - 1).get(j);
        int d = Integer.MAX_VALUE;
        int dg = Integer.MAX_VALUE;
        if (i < n - 1)
            d = ls.get(i).get(j) + minPath(ls, i + 1, j);
        if (i < n - 1 && j < n - 1)
            dg = ls.get(i).get(j) + minPath(ls, i + 1, j + 1);
        return Math.min(d, dg);
    }

    // Memoization way:
    public static int minPath(ArrayList<ArrayList<Integer>> ls, int i, int j, int dp[][]) {
        // Base case
        int n = ls.size();
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == n - 1)
            return ls.get(n - 1).get(j);
        int d = Integer.MAX_VALUE;
        int dg = Integer.MAX_VALUE;
        if (i < n - 1)
            d = ls.get(i).get(j) + minPath(ls, i + 1, j);
        if (i < n - 1 && j < n - 1)
            dg = ls.get(i).get(j) + minPath(ls, i + 1, j + 1);
        return dp[i][j] = Math.min(d, dg);
    }

    // Tabulazation way:TC->O(n*n) and SC->O(n*n)
    public static int minPathTab(ArrayList<ArrayList<Integer>> ls) {
        int n = ls.size();
        int dp[][] = new int[n][n];
        for (int k = 0; k < n; k++) {
            dp[n - 1][k] = ls.get(n - 1).get(k);
        }
        for (int x = n - 2; x >= 0; x--) {
            for (int y = 0; y <= x; y++) {
                int d = ls.get(x).get(y) + dp[x + 1][y];
                int dg = ls.get(x).get(y) + dp[x + 1][y + 1];
                dp[x][y] = Math.min(d, dg);
            }
        }
        return dp[0][0];
    }

    // Space optimisation
    public static int minPathSpace(ArrayList<ArrayList<Integer>> ls) {
    int n = ls.size();
    int[] temp = new int[n];

    // Initialize the temp array with the last row
    for (int i = 0; i < n; i++) {
        temp[i] = ls.get(n - 1).get(i);
    }

    for (int x = n - 2; x >= 0; x--) {
        int[] curr = new int[n];
        for (int y = 0; y <= x; y++) {
            int d = ls.get(x).get(y) + temp[y];
            int dg = ls.get(x).get(y) + temp[y + 1];
            curr[y] = Math.min(d, dg);
        }
        // Update the temp array
        temp = curr;
    }
    return temp[0];
}



    public static void main(String[] args) {
        /*
         * You are given a triangular arraylist"Triangle".
         * Your task is to return the minimum path sum
         * to reach from top to the bottom row.
         * 1
         * 2,3
         * 3,6,7
         * 8,9,6,10
         * Output:14
         * 
         * WE don't use the greedy algorithm
         * 
         * // IN the given example 1 is fixed
         * Try out all the paths->Recursion->Min(sum)
         * Represent(i,j)
         * explore all path(down and diagonal) (i+1,j) and (i+1)(j+1)
         * min of all path
         * f(n-1,m-1)
         * // f(0,0)=> min path from 0,0 to last row
         * f(i,j){
         * if(i==n-1) return a[n-1][j]
         * d=a[i][j]+f(i+1,j)
         * d=a[i][j]+f(i+1,j+1)
         * return min(d,dg);
         * 
         * // Recursion :TC->1+2+..n every takes 1 to 2 times
         * Time complexity:2^n
         * sc:O(n)
         * 
         * // So for the recursion we have to find the overlapping subproblem
         * 
         * }
         * 
         */
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(3);
        ArrayList<Integer> third = new ArrayList<>();
        third.add(3);
        third.add(6);
        third.add(7);
        ArrayList<Integer> forth = new ArrayList<>();
        forth.add(8);
        forth.add(9);
        forth.add(6);
        forth.add(10);
        ls.add(first);
        ls.add(second);
        ls.add(third);
        ls.add(forth);
        int n = ls.size();
        // int dp[][]=new int[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // dp[i][j]=-1;
        // }
        // }
        // System.out.println("Starting to ending min path:"+minPath(ls,0,0,dp));
        // System.out.println("Starting to ending min path:" + minPathTab(ls));
        System.out.println("Starting to ending min path:" + minPathSpace(ls));

    }
}
