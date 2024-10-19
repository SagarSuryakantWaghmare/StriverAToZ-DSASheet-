import java.lang.reflect.Array;
import java.util.*;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // List<List<Integer>> ans = new LinkedList<>();
        
        // // Iterate through the array
        // for (int i = 0; i < arr.length - 2; i++) {  // Limit to arr.length - 2 to prevent out of bounds
        //     for (int j = i + 1; j < arr.length - 1; j++) {
        //         for (int k = j + 1; k < arr.length; k++) {  // Correct indexing for the third element
        //             if (arr[i] + arr[j] + arr[k] == 0) {
        //                 List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
        //                 ans.add(triplet);
        //             }
        //         }
        //     }
        // }
        
        // return ans;

        // Better solution
        // List<List<Integer>> result = new ArrayList<>();
        // HashSet<List<Integer>> set = new HashSet<>();
        
        // for (int i = 0; i < nums.length - 1; i++) {
        //     HashSet<Integer> st = new HashSet<>();
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int third = -(nums[i] + nums[j]);
        //         if (st.contains(third)) {
        //             List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
        //             Collections.sort(triplet); // Sort to handle duplicates
        //             set.add(triplet);
        //         } else {
        //             st.add(nums[j]);
        //         }
        //     }
        // }
        
        // result.addAll(set);
        // return result;


            Arrays.sort(nums); // Sort the array to use two-pointer approach
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++; // Skip duplicates
                        while (j < k && nums[k] == nums[k - 1]) k--; // Skip duplicates
                        j++;
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return ans;
        }
  

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}

  
