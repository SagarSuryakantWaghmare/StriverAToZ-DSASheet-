import java.util.*;

public class BellmanFordAlogrithm {
    // Shortest path algorithm
    // for graphs with negative weights
    // but no negative cycles
    // Time complexity: O(V*E)
    // Space complexity: O(V)
    // V = number of vertices
    // E = number of edges
    // Bellman-Ford algorithm
    // 1. Initialize distances from the source to all vertices as infinite
    // 2. Set the distance to the source itself as 0
    // 3. Relax all edges |V| - 1 times
    // 4. Check for negative-weight cycles
    // 5. If a negative-weight cycle is detected, return -1
    // 6. Return the distance array
    // 7. If the distance to the destination is still infinite, return -1
    // 8. Otherwise, return the distance to the destination
    
    //It is implemented for the directed graph
    // If the graph is undirected, then we convert it to a directed graph
    public static int[] bellman_ford(int v,ArrayList<ArrayList<Integer>> edges,int S){
        int []dis=new int[v];
        for(int i=0;i<v;i++){
            dis[i]=(int)(1e8);
        }
        dis[S]=0;
        // V*E
        for(int i=0;i<v-1;i++){
            for(ArrayList<Integer> it:edges){
                int x=it.get(0);
                int y=it.get(1);
                int wt=it.get(2);
                if(dis[x]!=(int)(1e8) && dis[x]+wt<dis[y]){
                    dis[y]=dis[x]+wt;
                }
            }
        }
        // N th relaxation for negative cycle
        for(ArrayList<Integer> it:edges){
            int x=it.get(0);
            int y=it.get(1);
            int wt=it.get(2);
            if(dis[x]!=(int)(1e8) && dis[x]+wt<dis[y]){
                return new int[]{-1};
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int v = 5; 
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1, -1)));
        edges.add(new ArrayList<>(List.of(0, 2, 4)));
        edges.add(new ArrayList<>(List.of(1, 2, 3)));
        edges.add(new ArrayList<>(List.of(1, 3, 2)));
        edges.add(new ArrayList<>(List.of(1, 4, 2)));
        edges.add(new ArrayList<>(List.of(3, 2, 5)));
        edges.add(new ArrayList<>(List.of(3, 1, 1)));
        edges.add(new ArrayList<>(List.of(4, 3, -3)));
        int S = 0;
        int[] distances = bellman_ford(v, edges, S);
        if (distances[0] == -1) {
            System.out.println("Negative cycle detected");
        } else {
            System.out.println("Distances from source vertex " + S + ":");
            for (int i = 0; i < distances.length; i++) {
                System.out.println("Vertex " + i + ": " + distances[i]);
            }
        }

    }
}