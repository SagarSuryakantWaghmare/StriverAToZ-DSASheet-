import java.util.ArrayList;

public class DetectACycleInDirectedGraph {
    // Using the dfs techinque detect cycle in directed Graph
    public static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis) == true) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }
        pathVis[node] = 0; // Set pathVis[node] back to 0 after fully exploring the node and its descendants
        return false;
    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[v];
        int pathVis[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        boolean ans = isCycle(v, adj);
        if (ans) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");
        }
    }
}
