import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionaryTopoSort {

    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[v];
        Queue<Integer> q = new LinkedList<>();

        // Calculate in-degree
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        // Add nodes with in-degree 0 to queue
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Topological Sort using Kahn's Algorithm
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return ans;
    }

    public static String alienOrder(String[] words) {
        int k = 26; // assuming only lowercase a-z characters
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';
                    adj.get(u).add(v);
                    break;
                }
            }
        }

        ArrayList<Integer> topo = topoSort(adj, k);

        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            // Only include characters that were actually used
            boolean used = false;
            for (String word : words) {
                if (word.indexOf((char) (it + 'a')) != -1) {
                    used = true;
                    break;
                }
            }
            if (used) {
                ans.append((char) (it + 'a'));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String order = alienOrder(words);
        System.out.println("The alien dictionary order is: " + order);
    }
}
