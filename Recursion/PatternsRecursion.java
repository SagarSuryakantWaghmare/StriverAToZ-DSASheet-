import java.util.*;

public class PatternsRecursion {
    public static void rec(int idx, int arr[], int sum, int count, List<Integer> ls){
       if(idx == arr.length){
        if(sum == count){
            System.out.println(ls);
        }
        return;
       } 
       // Include the current element
       ls.add(arr[idx]);
       rec(idx + 1, arr, sum, count + arr[idx], ls);
       // Exclude the current element (backtrack)
       ls.remove(ls.size() - 1);
       rec(idx + 1, arr, sum, count, ls);
    }

    public static void main(String[] args) {
        //Printing subsequences whose sum is k
        
        // We just make sure to add in the sum or not 
        // like take it or not

        // Arr[]={1,2,1}  sum=2
        // so result=[1,1] and [2]

        // So we have to get the list
        int arr[] = {1, 2, 1};
        int sum = 2;
        List<Integer> ls = new ArrayList<>();
        rec(0, arr, sum, 0, ls);
    }
}