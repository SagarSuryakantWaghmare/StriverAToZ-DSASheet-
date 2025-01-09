public class NthRootOfAnInteger {
    public static int findRoot(int mid, int n, int m) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
            if (ans == m) return 1;
        }
        return 0;
    }
    public static int FindElement(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int find = findRoot(mid, n, m);
            if (find == 1) return mid;
            else if (find == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Finding the n th element of the m
        int n = 3;
        int m = 27;
        System.out.println(FindElement(n, m));
    }
}
