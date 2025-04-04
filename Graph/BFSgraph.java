import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSgraph {
    public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        // Create a list to store the BFS traversal
        ArrayList<Integer> bfs=new ArrayList<>();
        // Create a boolean array to keep track of visited nodes
        boolean vis[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while (!q.isEmpty()) {
            Integer node=q.poll();
            bfs.add(node);
            // Get all adjacent vertices of the dequeued
            // If a adjacent has not been visited, then max
            // Visited and enqueue it
            for(Integer it:adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
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
        ArrayList<Integer> bfsResult = bfsOfGraph(V, adj);
        System.out.println("BFS Traversal of the graph: " + bfsResult);
    }
}
