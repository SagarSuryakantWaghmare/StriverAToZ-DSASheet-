public class tugOfWar {

    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        backtrack(0,0,0,0,0,arr);
        System.out.println("Min difference between the tug of war: " + minDiff);
    }
    public static void backtrack(int idx, int count1, int sum1, int count2, int sum2, int arr[]) {
        int n = arr.length;
        if (idx == n) {
            if (Math.abs(count1 - count2) <= 1) {
                int currMin = Math.abs(sum1 - sum2);
                minDiff = Math.min(currMin, minDiff);
            }
            return;
        }

        if (count1 < (n+1)/2) {
            backtrack(idx + 1, count1 + 1, sum1 + arr[idx], count2, sum2, arr);
        }
        if (count2 < (n+1)/2) {
            backtrack(idx + 1, count1, sum1, count2 + 1, sum2 + arr[idx], arr);
        }
    }
}
