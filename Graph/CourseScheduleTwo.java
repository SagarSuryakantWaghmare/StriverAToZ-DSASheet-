import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleTwo {
    public static int[] findOrder(int numCourses,int [][] prerequisites){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []prerequisite:prerequisites){
               adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        // Step build in degree array
        int[] inDegree=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for(int neighbor:adj.get(i)){
                inDegree[neighbor]++;
            }
        }
        // Queue for the indegree 0
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        // Peform the bfs kahn's algorithm
        int [] topo=new int[numCourses];
        int index=0;
        while (!q.isEmpty()) {
            int node=q.poll();
            topo[index++]=node;
            for(int neighbor:adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        // step return topo
        if(index==numCourses){
            return topo;
        }
        else{
            return new int[0];
        }
    }

     public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        int[] order = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order)); // Output: [0, 1, 2, 3]
    }
}