public class SurrondedRegions {
    public static void printChar(char[][]a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int row,int col,int vis[][],char[][]grid,int dx[],int dy[]){
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m
            &&vis[nrow][ncol]==0&&grid[nrow][ncol]=='0'){
                dfs(nrow, ncol, vis, grid, dx, dy);
            }
        }

    }
    public static char[][] change(char[][]grid){
        // so we simply traverse the boundaries
        //And mark them as the visited and not converted
        // After that we converted them into zero
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int dx[]={-1,0,1,0};
        int dy[]={0,-1,0,1};

        // First row and last row
        for(int j=0;j<m;j++){
            //first row
            if(vis[0][j]==0&&grid[0][j]=='0'){
                dfs(0,j,vis,grid,dx,dy);
            }
            // last row
            if(vis[n-1][j]==0&&grid[n-1][j]=='0'){
                dfs(n-1,j,vis,grid,dx,dy);
            }
        }
        // First col and Last col
        for(int i=0;i<n;i++){
            if(vis[i][0]==0&&grid[i][0]=='0'){
                dfs(i,0,vis,grid,dx,dy);
            }
            if(vis[i][m-1]==0&&grid[i][m-1]=='0'){
                dfs(i,m-1,vis,grid,dx,dy);
            }
        }
        // Remaining convert to x
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(vis[i][j]==0&&grid[i][j]=='0'){
                    grid[i][j]='x';
                }
            }
        }
        return grid;

    }
    public static void main(String[] args) {
        char grid[][]={
            {'x','x','x','x','x'},
            {'x','0','0','x','0'},
            {'x','x','0','x','0'},
            {'0','0','x','x','x'}
        };
        printChar(grid);
        System.out.println("Change x to 0");
        char newG[][]=change(grid);
        printChar(newG);
    }
}
