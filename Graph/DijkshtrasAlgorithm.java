import java.util.*;

class DijkstrasAlgorithm {

    static class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    // Dijkstra's Algorithm for positive edge weights
    public static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[v];

        for (int i = 0; i < v; i++) {
            dist[i] = (int) 1e9;
        }

        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: u -> v with weight w
        // For undirected graph, add both u->v and v->u
        adj.get(0).add(new ArrayList<>(List.of(1, 2)));
        adj.get(0).add(new ArrayList<>(List.of(2, 4)));
        adj.get(1).add(new ArrayList<>(List.of(2, 1)));
        adj.get(1).add(new ArrayList<>(List.of(3, 7)));
        adj.get(2).add(new ArrayList<>(List.of(4, 3)));
        adj.get(3).add(new ArrayList<>(List.of(4, 1)));

        int source = 0;
        int[] distances = dijkstra(V, adj, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " -> " + distances[i]);
        }
    }
}
