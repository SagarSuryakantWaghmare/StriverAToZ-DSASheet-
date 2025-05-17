import java.util.*;

public class MinimumMultiplicationstoReachEnd {

    public static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> queue = new LinkedList<>();
        dist[start] = 0;
        queue.add(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int num = curr.first;
            int steps = curr.second;
            // If we reach the end, return the number of steps.
            if (num == end) return steps;
            for (int factor : arr) {
                int next = (num * factor) % mod;
                if (steps + 1 < dist[next]) {
                    dist[next] = steps + 1;
                    queue.add(new Pair(next, steps + 1));
                }
            }
        }

        return -1; // If end is not reachable.
    }

    // Pair class used for holding current number and steps
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        int result = minimumMultiplications(arr, start, end);
        System.out.println("Minimum multiplications to reach " + end + " from " + start + " = " + result);
    }
}
