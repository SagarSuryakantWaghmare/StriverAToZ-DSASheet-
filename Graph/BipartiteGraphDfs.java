import java.util.ArrayList;

public class BipartiteGraphDfs {
    // color=>col
    public static boolean dfs(int node,int col,ArrayList<ArrayList<Integer>> adj,int color[]){
        color[node]=col;
        for(int it:adj.get(node)){
            if(color[it]==-1){
                if(dfs(it,1-col,adj,color)==false){
                    return false;
                }
                else if(color[it]==col){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isBipartite(int v,ArrayList<ArrayList<Integer>> adj){
        int color[]=new int[v];
        for (int i = 0; i < v; i++) {
            color[i]=-1;
        }
        for (int i = 0; i < v; i++) {
            if(color[i]==-1){
                if(dfs(i,0,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
         int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(4).add(1);

        System.out.println("Is Bipartite Graph:" + isBipartite(V, adj));
    }
}
