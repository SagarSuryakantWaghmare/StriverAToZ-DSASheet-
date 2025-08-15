public class BestTimeToBuyAndSell {

    public static int maxProfit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j] - arr[i]);
            }
        }
        return max;
    }
    

    public static void main(String[] args) {
        // Main body
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
