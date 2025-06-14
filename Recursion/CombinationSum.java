import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void backtrack(int idx, int[] a, ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> ds,
            int target) {
        if (idx == a.length) {
            if (target == 0) {
                ls.add(new ArrayList<>(ds));
            }
            return;
        }
        if (a[idx] <= target) {
            ds.add(a[idx]);
            backtrack(idx + 1, a, ls, ds, target - a[idx]);
            ds.remove(ds.size() - 1);
        }
        backtrack(idx + 1, a, ls, ds, target);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 5, 4 };
        int target = 7;
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        backtrack(0, arr, ls, new ArrayList<>(), target);
        System.out.println(ls);
    }
}