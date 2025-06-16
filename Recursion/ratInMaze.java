public class ratInMaze {
    public static void print(int sr,int sc,int er,int ec,String s,int[][]maze,boolean[][]vis){
        if(sr<0||sc<0){
            return;
        }
        if(sr > er || sc > ec){
    return;
}

        if(sc==ec&&sr==er){
            System.out.println(s);
            return;
        }
        if(maze[sr][sc]==0){
            return;
        }
        if(vis[sr][sc]==true){
            return;
        }

        
        vis[sr][sc]=true;
        print(sr+1, sc, er, ec, s+"D", maze, vis);
        print(sr, sc+1, er, ec, s+"R", maze, vis);
        print(sr-1, sc, er, ec, s+"U", maze, vis);
        print(sr, sc-1, er, ec, s, maze, vis);
        vis[sr][sc]=false;
    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        // space complexity-O(b=n*n)
        
        // int[][] maze = { { 1, 0, 1, 1, 1, 1 },
        //         { 1, 1, 1, 1, 0, 1 },
        //         { 0, 1, 1, 1, 1, 1 },
        //         { 0, 0, 1, 0, 1, 1 } };
        int[][] maze = { { 1, 0, 1 },
        { 1, 1, 1 },
        { 0, 1, 1 } };
        boolean[][] isVisited = new boolean[rows][cols];
        print(0, 0, rows - 1, cols - 1, "", maze, isVisited);
    }
}