import java.util.*;

class DijkstrasAlgorithmSet {
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(Pair other) {
            if (this.dist == other.dist)
                return this.node - other.node; 
            return this.dist - other.dist;
        }
    }
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(S, 0)); 
        while (!set.isEmpty()) {
            Pair top = set.pollFirst();
            int u = top.node;
            int d = top.dist;
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0); 
                int w = neighbor.get(1);
                if (d + w < dist[v]) {
                    if (dist[v] != Integer.MAX_VALUE)
                        set.remove(new Pair(v, dist[v]));

                    dist[v] = d + w;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    // Example usage
    public static void main(String[] args) {
        int V = 3, S = 2;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 6)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));

        int[] result = dijkstra(V, adj, S);
        System.out.println("Shortest distances from source " + S + ": " + Arrays.toString(result));
    }
}
