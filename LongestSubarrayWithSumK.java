import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    // public static void longestSubarray(int []arr,int target){
    // int len=0;
    // int n=arr.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i; j < n; j++) {
    // int sum=0;
    // for (int k = i; k <= j; k++) {
    // sum+=k;
    // }
    // if(sum==target){
    // len=Math.max(len, j-i+1);
    // }
    // }
    // }
    // System.out.println("Maximum longest subarray length:"+len);
    // }

    // better solution and optimal for the neg and postive
    // public static void longestSubarray(int []a,int target){
    // Map<Integer,Integer> mp=new HashMap<>();
    // int sum=0;
    // int maxLen=0;
    // for (int i = 0; i < a.length; i++) {
    // sum+=a[i];
    // if(sum==target){
    // maxLen=Math.max(maxLen, i+1);
    // }
    // int rem=sum-target;
    // if(mp.containsValue(rem)){
    // int len=i-mp.get(rem);
    // maxLen=Math.max(maxLen,len);
    // }
    // mp.put(sum,i);

    // }
    // System.out.println(maxLen);

    // }

    // optimal solution-postive and zero
    public static void longestSubarray(int a[], int k) {
        int left = 0;
        int right = 0;
        int sum = a[0];
        int maxLen = 0;
        int n = a.length;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen, right-left+1);
            }
            right++;

            if (right < n)
                sum += a[right];
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        // arr[]=[1,2,3,1,1,1,4,2,3]
        // continuous subarray
        int arr[] = { 1, 2, 3, 1, 1, 1, 4, 2, 3 };
        int target = 3;
        longestSubarray(arr, target);
    }
}
