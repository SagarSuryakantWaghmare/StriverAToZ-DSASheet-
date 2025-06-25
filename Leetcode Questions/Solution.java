public class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -1_000_000_0000L, high = 1_000_000_0000L;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessEqual(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                count += countPositives(a, nums2, x);
            } else if (a < 0) {
                count += countNegatives(a, nums2, x);
            } else {
                if (x >= 0) count += nums2.length;
            }
        }
        return count;
    }

    private int countPositives(int a, int[] nums2, long x) {
        int low = 0, high = nums2.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((long)a * nums2[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countNegatives(int a, int[] nums2, long x) {
        int low = 0, high = nums2.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((long)a * nums2[mid] <= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums2.length - low;
    }

    public int kthSmallestProduct(int[] nums1, int[] nums2, int k) {
        return (int) kthSmallestProduct(nums1, nums2, (long) k);
    }
    public static void main(String[] args) {
        int arr[]={2,4};
        int arr1[]={3,7};
        System.out.println(kthSmallestProduct(arr,arr1,2));
    }
}
