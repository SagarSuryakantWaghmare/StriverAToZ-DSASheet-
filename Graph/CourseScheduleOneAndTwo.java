import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleOneAndTwo {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // So we first create the adj graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        // So we now have to write the topological sort graph
        int inDegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node : adj.get(i)) {
                inDegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            for (int i : adj.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        return topo.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites)); // Output: true
    }
}