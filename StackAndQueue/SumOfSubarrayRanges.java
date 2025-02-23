import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayRanges {
    public static int sumOfSubarrayRanges(int[] arr) {
        return sumSubarrayMaxs(arr) - sumSubarrayMins(arr);
    }

    // Function to calculate the sum of subarray minimums
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        // Finding the next smaller element and previous smaller element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                right[st.pop()] = i;
            }
            if (!st.isEmpty()) {
                left[i] = st.peek();
            }
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }

        return (int) sum;
    }

    // Function to calculate the sum of subarray maximums
    public static int sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        // Finding the next greater element and previous greater element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                right[st.pop()] = i;
            }
            if (!st.isEmpty()) {
                left[i] = st.peek();
            }
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2};
        System.out.println(sumOfSubarrayRanges(arr));  // Expected Output: 13
    }
}
