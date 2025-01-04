import java.util.*;

public class MergeOverlappingSubIntervals {
    public static List<List<Integer>> merge(List<List<Integer>> arr) {
        Collections.sort(arr, (a, b) -> a.get(0) - b.get(0));

        List<List<Integer>> ans = new ArrayList<>();

        // Brute force 
        // for (int i = 0; i < arr.size(); i++) {
        //     int start = arr.get(i).get(0);
        //     int end = arr.get(i).get(1);
        //     System.out.println(start+" "+end);

        //     // If the answer list is empty or current interval does not overlap with the last one
        //     if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < start) {
        //         // Add the current interval to the answer list
        //         ans.add(Arrays.asList(start, end));
        //     } else {
        //         // There is an overlap, so merge the current interval with the last one
        //         ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), end));
        //     }
        // }

        // Optimal
        for (int i = 0; i < arr.size(); i++) {
            if (ans.isEmpty() || arr.get(i).get(0) > ans.get(ans.size() - 1).get(1)) {
                ans.add(arr.get(i));
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr.get(i).get(1)));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
       
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(1, 3));
        intervals.add(Arrays.asList(2, 6));
        intervals.add(Arrays.asList(8, 9));
        intervals.add(Arrays.asList(2, 4));
        intervals.add(Arrays.asList(15, 18));
        intervals.add(Arrays.asList(16, 17));
        List<List<Integer>> mergedIntervals = merge(intervals);

        for (List<Integer> interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}
