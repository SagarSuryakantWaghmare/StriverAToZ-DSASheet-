import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathPrintingUndirectedGraph {

    public static class Pair {
        int node, weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public static void dijkstra(int v, List<List<Pair>> adj, int source) {
        int dist[] = new int[v + 1];
        int parent[] = new int[v + 1];
        // Initialize distances and parent
        for (int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            for (Pair neighbour : adj.get(u)) {
                int x = neighbour.node;
                int y = neighbour.weight;

                if (dist[u] + y < dist[x]) {
                    dist[x] = dist[u] + y;
                    pq.add(new Pair(x, dist[x]));
                    parent[x] = u;
                }

            }
        }
        System.out.println("Node\tDistance\tParent");
        for (int i = 1; i <= v; i++) {
            System.out.println(i + "\t" + dist[i] + "\t\t" + parent[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            adj.add(new ArrayList<>());

        adj.get(1).add(new Pair(2, 2));
        adj.get(2).add(new Pair(1, 2));

        adj.get(1).add(new Pair(4, 1));
        adj.get(4).add(new Pair(1, 1));

        adj.get(2).add(new Pair(3, 4));
        adj.get(3).add(new Pair(2, 4));

        adj.get(2).add(new Pair(5, 5));
        adj.get(5).add(new Pair(2, 5));

        adj.get(3).add(new Pair(5, 1));
        adj.get(5).add(new Pair(3, 1));

        adj.get(4).add(new Pair(3, 3));
        adj.get(3).add(new Pair(4, 3));

        dijkstra(V, adj, 1);
    }
}