import java.util.*;

public class TopologicalSortingDFS {
    // Topological sorting using DFS
    // Linear ordering of vertices such that y there is
    // an edge from x to y then x comes before y in the ordering
    public static void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }
    public static int [] topoSort(int v,ArrayList<ArrayList<Integer>> adj){
        int vis[]=new int[v];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,vis,st,adj);
            }
        }
        int ans[]=new int[v];
        int i=0;
        while (!st.isEmpty()) {
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6; 
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges as per the graph
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        int res[]=topoSort(V, adj);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}