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

    public static int Largest(int[] height) {
        int n = height.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        nse = nse(height);
        pse = pse(height);
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, height[i] * (nse[i] - pse[i] - 1));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Maximum :" + Largest(height));

    }
}