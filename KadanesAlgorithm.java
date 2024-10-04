public class KadanesAlgorithm {
    public static int maxSubarraySum(int[]arr){
        // Brute force approach
        // int max=Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i; j < arr.length; j++) {
        //         int sum=0;
        //         for (int k = i; k <= j; k++) {
        //             sum+=arr[k];
        //         }
        //         max=Math.max(max, sum);
        //     }
        // }
        // return max;


        // Better approach:O(n^2)

        // Optimal alogrithm
        // KadanesAlgorithm
        int sum=0;
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(sum==0) 
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        // Maximum subarray sum
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubarraySum(arr));
    }
}
