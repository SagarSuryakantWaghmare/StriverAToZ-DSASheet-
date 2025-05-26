public class PrismsAlgorithm {
    public static int primsAlgorithm(int[][]graph,int n){
        boolean[] vis=new boolean[n];
        int []key=new int[n];
        int []parent=new int[n];
        for(int i=0;i<n;i++){
            key[i]=Integer.MAX_VALUE;
            parent[i]=-1;
        }
        key[0]=0; 
        parent[0]=-1; 
        int mstWeight = 0;
        for(int i=0;i<n-1;i++){
            int u=minKey(key,vis,n);
            vis[u]=true;
            mstWeight+=key[u];
            for(int v=0;v<n;v++){
                if(graph[u][v]!=0 && !vis[v] && graph[u][v]<key[v]){
                    key[v]=graph[u][v];
                    parent[v]=u;
                }
            }
        }
        return mstWeight;
    }
    private static int minKey(int[] key, boolean[] vis, int n) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < n; v++) {
            if (!vis[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 1, 0, 0},
            {4, 0, 2, 5, 0},
            {1, 2, 0, 8, 0},
            {0, 5, 8, 0, 3},
            {0, 0, 0, 3, 0}
        };
        
        int n = graph.length; 
        int mstWeight = primsAlgorithm(graph, n);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}