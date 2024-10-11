import java.util.HashMap;
public class CountSubarray {

   // Brute force:O(n^3)
   // public static int countSubarray(int[]arr,int k){
   // int count=0;
   // int n=arr.length;
   // for (int i = 0; i <n; i++) {
   // for (int j = i; j < n; j++) {
   // int sum=0;
   // for (int l = i; l<=j; l++) {
   // sum=sum+arr[l];
   // }
   // if(sum==k){
   // count++;
   // }

   // }

   // }
   // return count;
   // }

   // Better approach:sum=0

   // public static int countSubarray(int[]arr,int k){
   // int count=0;
   // int n=arr.length;
   // for (int i = 0; i < n; i++) {
   // int sum=0;
   // for (int j = i; j < n; j++) {
   // sum+=arr[j];
   // if(sum==k){
   // count++;
   // }
   // }

   // }
   // return count;
   // }

   // Optimal solution:
   public static int countSubarray(int[] arr, int k) {
      int count = 0;
HashMap<Integer, Integer> mp = new HashMap<>();
mp.put(0, 1);
int preSum = 0;

for (int i = 0; i < arr.length; i++) {
    preSum += arr[i];
    int remove = preSum - k;

    if (mp.containsKey(remove)) {
        count += mp.get(remove);
    }

    mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);
}

return count;

   }

   public static void main(String[] args) {
      // Number of subarrays with sum K
      // arr[]={1,2,3,-3,1,1,1,4,2,-3}
      // k=3
      // Subarrays:
      // 1 2 3 -3
      // 2 3 -3 1
      // 3
      // 3,-3, 1, 1,1
      // 4 2 -3
      int arr[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
      int k = 3;
      System.out.println("Number of subarrays:" + countSubarray(arr, k));
   }
}
