import java.util.ArrayList;

public class DetectCycleUsingDFS {
    // Detect the Cycle using DFS
    public static boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                if (dfs(adjNode, node, vis, adj) == true) {
                    return true;
                }
            } else if (adjNode != parent)
                return true;
        }
        return false;
    }
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj) == true)
                    return true;
            }
        }
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 1);
        System.out.println("Cycle Detected:" + isCycle(v, adj));
    }
}
