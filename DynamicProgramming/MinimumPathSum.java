public class MinimumPathSum {
    // So we are given the grid has some cost associated with it.
    /*
     * Find a path from top left to the boottom right which minimzes
     * the sum of the cost of all numbers along the path.You need
     * to tell the minimum sum of that path.
     */

    // We can't follow greedy algorithm
    /*
     * So if we have to get every the minimum form the current
     * matrix we get the minimum there are might be other way
     * which have the greater number at the current states
     * but have the minimum so we cannot for the greedy approach.
     */

    // Try out all paths form that and find the minimum form there.

    // We can do the recursion for the going from the start to end.
    // public static int shortPath(int mat[][],int i,int j){
    // if(i==0&&j==0) return mat[0][0];
    // if(i<0||j<0) return Integer.MAX_VALUE;

    // int up = Integer.MAX_VALUE;
    // int left = Integer.MAX_VALUE;

    // if(i>0) up = mat[i][j] + shortPath(mat, i-1, j);
    // if(j>0) left = mat[i][j] + shortPath(mat, i, j-1);

    // return Math.min(up, left);
    // }

    public static int shortPath(int mat[][], int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return dp[0][0] = mat[0][0];
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i > 0)
            up = mat[i][j] + shortPath(mat, i - 1, j, dp);
        if (j > 0)
            left = mat[i][j] + shortPath(mat, i, j - 1, dp);
        return dp[i][j] = Math.min(up, left);
    }

    // public static int shortPathTab(int[][] mat, int i, int j) {
    //     int n = mat.length;
    //     int m = mat[0].length;
    //     int dp[][] = new int[i][j];
    //     for (int k = 0; k < n; k++) {
    //         for (int l = 0; l < m; l++) {
    //            if(k==0&&l==0) dp[k][l]=mat[0][0];
    //            else{
    //             int up=Integer.MAX_VALUE;
    //             int left=Integer.MAX_VALUE;
    //             if(k>0) up=mat[k][l]+dp[k-1][l];
    //             if(l>0) left=mat[k][l]+dp[k][l-1];
    //             dp[k][l]=Math.min(up,left);
    //            } 
    //         }
    //     }
    //     return dp[n-1][m-1];
    // }


    public static int shortPathSpaceOptimize(int[][] mat, int i, int j) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Space optimized approach - only need previous row
        int[] prev = new int[m];
        
        for (int k = 0; k < n; k++) {
            int[] temp = new int[m];
            for (int l = 0; l < m; l++) {
                if (k == 0 && l == 0) {
                    temp[l] = mat[0][0];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    
                    if (k > 0) up = mat[k][l] + prev[l];  // from previous row
                    if (l > 0) left = mat[k][l] + temp[l-1];  // from current row
                    
                    temp[l] = Math.min(up, left);
                }
            }
            prev = temp;  // update previous row
        }
        return prev[m-1];
    }

    // Space optimizatin of the given min path
    // So get using the prev row and current row


    public static void main(String[] args) {
        int mat[][] = { { 10, 8, 2 },
                { 10, 5, 100 },
                { 1, 1, 2 } };
        // Output:24
        int n = mat.length;
        int m = mat[0].length;
        // int dp[][]=new int[n][m];
        // for(int i=0;i<n;i++){
        // for(int j=0;j<m;j++){
        // dp[i][j]=-1;
        // }
        // }
        // System.out.println("Shortest path from the top to bottom
        // right:"+shortPath(mat,n-1,m-1,dp));
        System.out.println("Shortest path from the start to end:" + shortPathSpaceOptimize(mat, n, m));
    }
}
