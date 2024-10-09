import java.util.*;
/**
 * LongestConsecutiveSubsequence
 */
public class LongestConsecutiveSubsequence {
    // public static int longestConsecutive(int[] nums) {
    // int longest = 1;
    // for (int i = 0; i < nums.length; i++) {
    // int x = nums[i];
    // int count = 1;
    // while (linearSearch(nums, x + 1)) {
    // x = x + 1;
    // count = count + 1;
    // }
    // if (count > longest) {
    // longest = count;
    // }
    // }
    // return longest;
    // }

    // public static int longestConsecutive(int[] arr) {
    //     if (arr == null || arr.length == 0) {
    //         return 0;
    //     }

    //     Arrays.sort(arr);
    //     int longest = 1;
    //     int currentLongest = 1;
    //     int lastSmallest = arr[0];

    //     for (int i = 1; i < arr.length; i++) {
    //         if (arr[i] - 1 == lastSmallest) {
    //             currentLongest++;
    //             lastSmallest = arr[i];
    //         } else if (arr[i] == lastSmallest) {
    //             continue;
    //         } else {
    //             longest = Math.max(longest, currentLongest);
    //             currentLongest = 1;
    //             lastSmallest = arr[i];
    //         }
    //     }

    //     return Math.max(longest, currentLongest);

    // }

    // public static boolean linearSearch(int[] arr, int target) {
    //     for (int num : arr) {
    //         if (num == target) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

   // optimal solution
   public static int longestConsecutive(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int num : arr) {
        set.add(num);
    }

    int longestStreak = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            while (set.contains(currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }

    return longestStreak;
}
    
    

    public static void main(String[] args) {
        int arr[] = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        System.out.println(longestConsecutive(arr));
    }
}