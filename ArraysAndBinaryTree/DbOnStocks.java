public class DbOnStocks {
    // Db problem:Buy and sell stocks
    public static int maxProfit(int []arr){
       int min=arr[0];
       int profit=0;
       for (int i = 0; i < arr.length; i++) {
        int cost=arr[i]-min;
        profit=Math.max(profit, cost);
        min=Math.min(min, arr[i]);
       }
       return profit;
    }
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
        // if you are selling on ith day
        // you buy on the minimum price from 1st price->(i-1)
        
    }
}
