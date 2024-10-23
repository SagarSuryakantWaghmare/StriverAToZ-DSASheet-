
// Four sum
// 4 sum
/**
 * fourSum
 */
import java.lang.reflect.Array;
import java.util.*;

public class fourSum {
    // Brute force approach
    // public static List<List<Integer>> foursum(int[] nums) {
    // List<List<Integer>> result = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n - 3; i++) {
    // for (int j = i + 1; j < n - 2; j++) {
    // for (int k = j + 1; k < n - 1; k++) {
    // for (int l = k + 1; l < n; l++) {
    // if (nums[i] + nums[j] + nums[k] + nums[l] == 0) {
    // List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
    // Collections.sort(quadruplet);
    // if (!result.contains(quadruplet)) {
    // result.add(quadruplet);
    // }
    // }
    // }
    // }
    // }
    // }
    // return result;
    // }

    // Better solution

    // public static List<List<Integer>> foursum(int[] nums, int target) {
    // List<List<Integer>> result = new ArrayList<>();
    // int n = nums.length;

    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n - 1; j++) {
    // Set<Integer> st = new HashSet<>();
    // for (int k = j + 1; k < n; k++) {
    // int sum = nums[i] + nums[j] + nums[k];
    // int fourth = target - sum;

    // // If the set contains the fourth number, we found a quadruplet.
    // if (st.contains(fourth)) {
    // List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k],
    // fourth));
    // result.add(temp);
    // }

    // // Add the current number to the set to track possible pairs.
    // st.add(nums[k]);
    // }
    // }
    // }
    // return result;
    // }

    // Optimal solution
    public static List<List<Integer>> foursum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Avoid duplicates for the first number.

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // Avoid duplicates for the second number.

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(temp);

                        // Avoid duplicates for the third number.
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        // Avoid duplicates for the fourth number.
                        while (k < l && nums[l] == nums[l - 1])
                            l--;

                        // Move both pointers after storing the result.
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // we sum the 4 numbers in the arr then we get the target 0
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        System.out.println(foursum(arr, 0));
    }
}