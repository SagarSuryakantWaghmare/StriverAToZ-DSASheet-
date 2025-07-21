public class MaximumAndMinimumFallingPathSumVariableStartingAndEnding {

    // Recurrence:
    /*
     * 1.Express (i,j), base case
     * 2.Explore all paths
     * 3.max among all paths
     * 4.return all paths
     */

    /*
     * code:
     * f(i,j){
     * if(i==0) return a[0][j];
     * // we are going from the n-1 to 1
     * if(j<0||j>=m) return Integer.MIN_VAUE;
     * }
     */
    // public static int maxPath(int[][] mat, int i, int j) {
    // int n = mat.length;
    // int m = mat[0].length;

    // // Base case:
    // if (i == 0)
    // return mat[0][j];
    // if (j < 0 || j >= m)
    // return Integer.MIN_VALUE;
    // int up = mat[i][j] + maxPath(mat, i - 1, j);
    // int upL = (j > 0) ? mat[i][j] + maxPath(mat, i - 1, j - 1) :
    // Integer.MIN_VALUE;
    // int upR = (j < m - 1) ? mat[i][j] + maxPath(mat, i - 1, j + 1) :
    // Integer.MIN_VALUE;

    // return Math.max(up, Math.max(upL, upR));
    // }

    // Memoization way:
    public static int maxPath(int[][] mat, int i, int j, int[][] dp) {
        int n = mat.length;
        int m = mat[0].length;

        // Base case
        if (i == 0)
            return mat[0][j];
        if (j < 0 || j >= m)
            return Integer.MIN_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];

        // Other cases
        int up = mat[i][j] + maxPath(mat, i - 1, j, dp);
        int upL = (j > 0) ? mat[i][j] + maxPath(mat, i - 1, j - 1, dp) : Integer.MIN_VALUE;
        int upR = (j < m - 1) ? mat[i][j] + maxPath(mat, i - 1, j + 1, dp) : Integer.MIN_VALUE;

        return dp[i][j] = Math.max(up, Math.max(upL, upR));
    }

    // Tabulation way:
    public static int maxPathTab(int[][] mat, int n, int m) {
        int[][] dp = new int[n][m];
        // Initialize the first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }
        // Fill up the rest of the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = mat[i][j] + dp[i - 1][j];
                int upR = (j < m - 1) ? mat[i][j] + dp[i - 1][j + 1] : Integer.MIN_VALUE;
                int upL = (j > 0) ? mat[i][j] + dp[i - 1][j - 1] : Integer.MIN_VALUE;
                dp[i][j] = Math.max(up, Math.max(upR, upL));
            }
        }
        // Find the maximum value in the last row
        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxSum = Math.max(maxSum, dp[n - 1][j]);
        }
        return maxSum;
    }

    public static int maxPathSpace(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] prev = new int[m];
        int[] curr = new int[m];

        // Initialize the first row
        for (int j = 0; j < m; j++) {
            prev[j] = mat[0][j];
        }

        // Fill up the rest of the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = mat[i][j] + prev[j];
                int upR = (j < m - 1) ? mat[i][j] + prev[j + 1] : Integer.MIN_VALUE;
                int upL = (j > 0) ? mat[i][j] + prev[j - 1] : Integer.MIN_VALUE;
                curr[j] = Math.max(up, Math.max(upR, upL));
            }
            // Swap prev and curr arrays
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Find the maximum value in the last row
        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxSum = Math.max(maxSum, prev[j]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        /*
         * Dp on grids
         * (0,0)=>(n-1)(m-1)
         * // fixed to variable
         * variable to variable
         */

        /*
         * Problem statements
         * You have been given on n*m matrix filled with integers numbers,
         * find the maximum sum that can be obtained from a path string any
         * cell in the first row to any cell in the last row
         * 
         * From a cell in a row, you can move to another cell directly below
         * that row,or diagrally below left or right. So from a particular
         * cell(row,col) we can move in three directions
         * i.e:
         * Down (row+1,col)
         * Down left diagonal:(row+1)(col-1)
         * Down right diagonal:(row+1)(col+1)
         */
        int mat[][] = { { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 }
        };
        // * So we don't apply the greedy algorithm

        // From any cell ->1 st row
        // Any all to last cell

        // Output for the maximum paht will be 2->100->1->2
        // Maximum path sum:105
        int n = mat.length;
        int m = mat[0].length;
        int max = Integer.MIN_VALUE;
        // Recursion:time complexity:O(3^n)
        int dp[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // for (int j = 0; j < m; j++) {
        // max = Math.max(max, maxPath(mat, n - 1, j, dp));
        // }
        // System.out.println("Maximum path from variable starting to variable end: " +
        // max);
        // System.out.println(maxPathTab(mat, n, m));
        System.out.println(maxPathSpace(mat));
    }
}
