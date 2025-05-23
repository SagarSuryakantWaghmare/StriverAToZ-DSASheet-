public class FloydWarshellAlgorithm {
    public static void shortestPath(int[][]mat){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=(int)(1e9);
                }
                if(i==j) mat[i][j]=0;
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=Math.min(mat[i][j],
                    mat[i][k]+mat[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==(int)(1e9)){
                    mat[i][j]=-1;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Floyd Warshell Algorithm - finds shortest paths between all pairs of vertices
        
        // Example graph represented as adjacency matrix
        // -1 means there is no direct edge between vertices
        int[][] graph = {
            {0, 3, -1, 5},
            {2, 0, -1, 4},
            {-1, 1, 0, -1},
            {-1, -1, 2, 0}
        };
        
        int n = graph.length;
        System.out.println("Original Distance Matrix:");
        printMatrix(graph);
        shortestPath(graph);
        System.out.println("\nShortest Distance Matrix after applying Floyd Warshall Algorithm:");
        printMatrix(graph);
    }
    private static void printMatrix(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(mat[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}