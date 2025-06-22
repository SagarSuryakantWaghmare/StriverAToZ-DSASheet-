import java.util.*;
public class maximumSumofNonAdjacentElements {

    // Using recursion
    // public static int f(int idx,int arr[]){
    //     if(idx==0){ return arr[idx];}
    //     if(idx<0) return 0;
    //     int pick=arr[idx]+f(idx-2, arr); 
    //     int notpick=0+f(idx-1, arr);
    //     return Math.max(pick,notpick);
    // }

    // Memoziation 
   
    

    // Tabulazation:
    public static void main(String[] args) {
        int arr[]={2,1,1,2};
        // Print all subsequences
        // There is techinque of the pick and non-pick
        /*
         * 1.Ind
         * 2.Do sheffs on that index
         * 3.REturn best.
         */
        int n=arr.length;
        // Recursion way:
        // System.out.println(f(n-1, arr));


        // Memoziation time complexity:
        // TC->O(n) and SC->O(n)+O(n)
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        // System.out.println(fn(n-1,dp,arr));


        // Tabulatation:
        // dp[0]=arr[0];
        // int neg=0;
        // // Bottom up
        // for(int i=1;i<n;i++){
        //     int pick=arr[i];
        //     if(i>1) pick+=dp[i-2];
        //     int notpick=0+dp[i-1];
        //     dp[i]=Math.max(pick,notpick);
        // }
        // System.out.println(dp[n-1]);



        // Space optimazation
        int prev=arr[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=arr[i];
            if(i>1) pick+=prev2;
            int notpick=0+prev;
            int curr=Math.max(pick, notpick);
            prev2=prev;
            prev=curr;

        }
        System.out.println(prev);
    }
    
}