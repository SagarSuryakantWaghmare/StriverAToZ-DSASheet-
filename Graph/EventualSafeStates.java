import java.util.*;

public class EventualSafeStates {
    public static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public static ArrayList<Integer> eventualSafeNodes(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] check = new int[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (check[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }

      public static void main(String[] args) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         int n = 5; // Number of nodes in the graph
         for (int i = 0; i < n; i++) {
             adj.add(new ArrayList<>());
         }
     
         // Sample graph with a cycle
         adj.get(0).add(1);
         adj.get(0).add(2);
         adj.get(1).add(2);
         adj.get(1).add(3);
         adj.get(2).add(3);
         adj.get(3).add(4);
         adj.get(4).add(0); 
     
         ArrayList<Integer> ans = eventualSafeNodes(n, adj);
     
         // Print the safe nodes
         if (ans.size() > 0) {
             System.out.println("Safe states (nodes from which no cycle can be reached):");
             for (int node : ans) {
                 System.out.print(node + " ");
             }
         } else {
             System.out.println("There are no safe states in the graph.");
         }
     
    }
}
