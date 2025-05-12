import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {

    // We can move only in the four Direction
    // We have to find the Shortest path so we are going to use the Djiks+htra Algorithm
    // So we are using the Priority Queue to store the 
    // pq dist,row,col

    public static class Pair{
        int weight,row,col;
        Pair(int weight,int row,int col){
            this.weight=weight;
            this.row=row;
            this.col=col;
        }
    }
    public static int ShortestPath(int[][] grid,int []source,int distination[]){
        if(source[0]==distination[0]&&source[1]==distination[1]) return 0;
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int [][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[source[0]][source[1]]=0;
        q.add(new Pair(0, source[0], source[1]));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};

        while (!q.isEmpty()) {
            Pair it=q.peek();
            q.remove();
            int dis=it.weight;
            int r=it.row;
            int c=it.col;
            // 4 dir
            for(int i=0;i<4;i++){
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr>=0&& newr<n&&newc>-0&&newc<m&&grid[newr][newc]==1 &&dis+1<dist[newr][newc]){
                  dist[newr][newc]=1+dis;
                  if(newr==distination[0]&&newc==distination[1]) return dis+1;
                  q.add(new Pair(1+dis, newr, newc));
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int maze[][]={
            {1,1,1,1},
            {1,1,0,1},
            {1,1,1,1},
            {1,1,0,0},
            {1,0,0,0}
        };
        int src[]={0,1};
        int dist[]={2,2};
        System.out.println(ShortestPath(maze,src,dist));

    }
}