import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKSteps {

    public static class Pair {
        int destination;
        int price;

        Pair(int destination, int price) {
            this.destination = destination;
            this.price = price;
        }
    }

    public static class Tuple {
        int stops;
        int node;
        int totalCost;

        Tuple(int stops, int node, int totalCost) {
            this.stops = stops;
            this.node = node;
            this.totalCost = totalCost;
        }
    }

    public static int CheapestFlight(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));

        int[] minCost = new int[n];
        for (int i = 0; i < n; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }
        minCost[src] = 0;

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int stops = current.stops;
            int node = current.node;
            int costSoFar = current.totalCost;

            if (stops > k) continue;

            for (Pair neighbor : graph.get(node)) {
                int neighborNode = neighbor.destination;
                int newCost = costSoFar + neighbor.price;

                if (newCost < minCost[neighborNode]) {
                    minCost[neighborNode] = newCost;
                    queue.add(new Tuple(stops + 1, neighborNode, newCost));
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 2, 600},
            {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println("Cheapest Flights: " + CheapestFlight(n, flights, src, dst, k));
    }
}
