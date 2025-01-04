import java.util.ArrayList;

public class Leaders {
    public static int[] leaders(int arr[]){
        ArrayList<Integer> le=new ArrayList<>();
        
        int maxi=Integer.MIN_VALUE;
        int n=arr.length;
        for (int i =n-1; i >= 0; i--) {
            if(arr[i]>maxi){
                maxi=arr[i];
                le.add(arr[i]);
            }
        }
        int ans[]=new int[le.size()];
        for (int i = 0; i < le.size(); i++) {
            ans[i] = le.get(le.size() - 1 - i);
        }
        return ans;
    }
    public static void main(String[] args) {
        // Leaders in an array
        // Everything form the right of the numbers must be smaller than the number
        int arr[]={10,22,12,3,0,6};
        // brute force:
        // Going one by one to every element and check the right side of the array is less
        // if it is less than then return this is leader  or add to the array.

        // O(n^2)-time complexity
        // O(n)-space complexity:In the worst case.

        // Optimal solution:
        // O(n)-time complexity
        //  we simply go form the last to first
        // Assinging like the int maxi=integer.min
        int ans[]=leaders(arr);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
