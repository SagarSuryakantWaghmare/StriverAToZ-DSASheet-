public class CherryPickup {
    // 3d problem
    // Grid problem
    // So we have a fixed starting point and variable ending point
    // We can start from (0,0) and end at (n-1)(m-1)
    // Explore all paths
    // f(i1,j1,i2,j2) = f(i1+1,j1,i2+1,j2) + f(i1+1,j1,i2,j2+1) + f(i1,j1+1,i2+1,j2) + f(i1,j1+1,i2,j2+1)
    // Max sum
    // recursion All path of person 1
    // recursion all path of person 2

    // recursion
    /*
     * f(i,j1,,j2){
     * if(j1<0||j1>=m||j2<0||j2>=m){
     * return -1e8
     * }
     * if(i==n-1){
     * if(j1!=j2){
     *    return a[i][j1];
     * }
     * else return a[i][j1]+a[i][j2];
     * 
     * 
     * }
    //  * Explore all path form both person
    int dj[]={-1,0,+1}
    for(dj1->-1 ->+1){
    for(dj2->-2->+1){
    if(j1==j2){
    maxi=Math.max(a[i][j1]+f(i+1,j1+dj1,j2+dj2))
    }
    else{
    maxi=Math.max(maxi,a[i][j1]+a[i][j2]+f(i+1,j+1))
    }
    }}
    // time complexity:O(3^n*3^n) emp
     */
    public static int maxPath(int[][]grid,int i,int j1,int j2){
        int m=grid[0].length;
        int maxi=Integer.MIN_VALUE;
        int n=grid.length;
        if(j1<0||j1>=m||j2<0||j2>=m){
            return Integer.MIN_VALUE;
        }
        if(i==n-1){
           if(j1==j2) return grid[i][j1];
           else return grid[i][j1]+grid[i][j2];
        }
        int dj[]={-1,0,1};
        for(int x:dj){
            for(int y:dj){
                if(j1==j2){
                    maxi=Math.max(maxi,grid[i][j1]+maxPath(grid, i+1, j1+x, j2+y));
                }
                else{
                    maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+maxPath(grid, i+1, j1+x, j2+y));
                }
            }
        }
        return maxi;
    }
    // Memoization method:
    public static int maxPathMemo(int[][]grid,int i,int j1,int j2,int dp[][][]){
        int n=grid.length;
        int m=grid[0].length;
        int maxi=Integer.MIN_VALUE;
        if(j1<0||j1>=m||j2<0||j2>=m){
            return Integer.MIN_VALUE;
        }
        if(i==n-1){
           if(j1==j2) return grid[i][j1];
           else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        
        int dj[]={-1,0,1};
        for(int x:dj){
            for(int y:dj){
                if(j1==j2){
                    maxi=Math.max(maxi,grid[i][j1]+maxPathMemo(grid, i+1, j1+x, j2+y, dp));
                }
                else{
                    maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+maxPathMemo(grid, i+1, j1+x, j2+y, dp));
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public static void main(String[] args) {
        int grid[][]={
            {2,3,4,8},
            {5,3,6,3},
            {3,5,2,3},
            {9,3,8,1}
        };
        int n=grid.length;
        int m=grid[0].length;
        int[][][]dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        System.out.println("Maximum number for both:"+maxPathMemo(grid,0,0,m-1,dp));

    }

}
