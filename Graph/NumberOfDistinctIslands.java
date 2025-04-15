import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static void dfs(int row,int col,int [][]grid,ArrayList<String> ls,int[][]vis,int row0,int col0){
        vis[row][col]=1;
        ls.add(toString(row-row0, col-col0));
        int dx[]={-1,0,1,0};
        int dy[]={0,-1,0,1};
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0&&nrow<n&&ncol<m&&ncol>=0&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                dfs(nrow, ncol, grid, ls, vis, row0, col0);
            }
        }

    }
    public static String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    public static int noOfIslands(int[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        HashSet<ArrayList<String>>st=new HashSet<>();
        int vis[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j]==0&&grid[i][j]==1){
                    ArrayList<String> ls=new ArrayList<>();
                    dfs(i,j,grid,ls,vis,i,j);
                    st.add(ls);
                }
            }
        }
        return st.size();

    }

    public static void main(String[] args) {
        int grid[][]={
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,1,1},
            {1,1,0,1,0}
        };
        System.out.println("Number of Distinct Islands"+noOfIslands(grid));

        
    }
}