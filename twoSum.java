/**
 * twoSum
 */
import java.util.*;
public class twoSum {
    // public static int[] twosum(int []arr,int target){
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = 0; j < arr.length; j++) {
    //             if(i==j) continue;
    //             if(arr[i]+arr[j]==target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }

    // This above is O(n^2)

    //Better solution
    // Hashing 
    public static int[] twosum(int []arr,int target){
        
        return new int[]{-1,-1};
    }
    

    public static void main(String[] args) {
        // Two sum:leetcode 1
        // Two sum
        
        int arr[]={2,6,4,11,20};
        int target=24;
        int ans[]=twosum(arr, target);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}