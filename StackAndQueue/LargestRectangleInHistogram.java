import java.lang.Thread.State;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int[] pse(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[] nse(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    // public static int Largest(int[] height) {
    //     int n = height.length;
    //     int nse[] = new int[n];
    //     int pse[] = new int[n];
    //     nse = nse(height);
    //     pse = pse(height);
    //     int maxi = 0;
    //     for (int i = 0; i < n; i++) {
    //         maxi = Math.max(maxi, height[i] * (nse[i] - pse[i] - 1));
    //     }
    //     return maxi;
    // }

    // Optimal solution
    // We have to just do in the O(n) in the above solution 
    // It just we do in the int the O(5n)
    // We have to in the form of the to get the optimal ones
    // so we do in the one traversal also
    // It just to express the things should much matter at.
    public static int Largest(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxarea = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int element = st.pop(); // Pop the top element
                int nse = i; // Next smaller element index
                int pse = st.isEmpty() ? -1 : st.peek(); // Previous smaller element index
                maxarea = Math.max(maxarea, arr[element] * (nse - pse - 1));
            }
            st.push(i); // Push the current index
        }

        // Process remaining elements in the stack
        while (!st.isEmpty()) {
            int element = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxarea = Math.max(maxarea, arr[element] * (nse - pse - 1));
        }

        return maxarea;
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Maximum :" + Largest(height));

    }
}