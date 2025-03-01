import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    // public static ArrayList maximum(int[]nums,int k){
    //     int max=1;
    //     int n=nums.length;
    //     ArrayList<Integer> ls=new ArrayList<>();
    //     for (int i = 0; i <n-k; i++) {
    //         int maxi=nums[i];
    //         for (int j = i; j < i+k-1; j++) {
    //             maxi=Math.max(maxi, nums[j]);
    //         }
    //         ls.add(maxi);

    //     }
    //     return ls;
    // }

    //Monoatomic Stack

    public static ArrayList<Integer> maximum(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int j = 0; j < nums.length; j++) {
            if (!dq.isEmpty() && dq.peekFirst() <= j - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(j);
            if (j >= k - 1) {
                result.add(nums[dq.peekFirst()]); 
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[]={1,3,-1,-3,5,3,2,16};
        int k=3;
        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
        ArrayList<Integer>res=maximum(nums,k);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }
}
