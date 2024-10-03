import java.util.Arrays;
import java.util.*;
public class majorityElement {
    // public static int major(int []arr,int n){
    // Arrays.sort(arr);
    // return arr[n/2];
    // }

    // Moore's Voting algorithm
    public static int major(int []arr,int n){
        int count=0;
        int el=0;
        for (int i = 0; i < n; i++) {
            if(count==0){
                count=1;
                el=arr[i];
            }
            else if(arr[i]==el){
               count++; 
            }
            else{
                count--;
            }
        }
        int count1=0;
        for (int i = 0; i <n; i++) {
            if(arr[i]==el) count++;
        }
        if(count1>n/2){
            return el;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={2,2,3,3,1,2,2};
        int n=arr.length;
        System.out.println(major(arr,n));
    }
}
