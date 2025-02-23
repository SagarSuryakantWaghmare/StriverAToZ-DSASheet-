import java.util.*;

public class sumOfSubarrayMinimum {
    public static int[] nse(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        Arrays.fill(ans, n); // Default value is `n` (out of bounds)

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] pse(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        Arrays.fill(ans, -1); // Default value is `-1` (out of bounds)

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        
        int[] left = new int[n];  // Distance to Previous Smaller Element
        int[] right = new int[n]; // Distance to Next Smaller Element

        int[] pse = pse(arr);
        int[] nse = nse(arr);

        for (int i = 0; i < n; i++) {
            left[i] = i - pse[i];  // Distance from previous smaller
            right[i] = nse[i] - i; // Distance to next smaller
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr)); // Expected Output: 17
    }
}
