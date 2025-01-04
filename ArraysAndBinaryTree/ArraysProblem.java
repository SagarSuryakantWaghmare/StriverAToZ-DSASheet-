import java.util.Arrays;
import java.util.Stack;

/**
 * ArraysProblem
 */
public class ArraysProblem {
    public static void largestInArray(int []arr){
        // This is burte force approch:O(n logn)
        // Arrays.sort(arr);
        // System.out.println(arr[arr.length-1]);
        // optimial solution
        // Time complexity:O(n)
        int largest=arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println(largest);

    }
    public static int[] secondLargestElement(int[]arr){
        int sLargest=mSecondLargest(arr);
        int sSmallest=mSecondSmallest(arr);
        int result[]=new int[2];
        result[0]=sLargest;
        result[1]=sSmallest;
        return result;
    }
    public static int mSecondLargest(int []arr){
        if(arr.length<2){
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
           if(arr[i]>largest){
            secondLargest=largest;
            largest=arr[i];
           }
           else if(arr[i]>secondLargest && arr[i]!=largest){
            secondLargest=arr[i];
           }
        }
        return secondLargest;
    }
    public static int mSecondSmallest(int[]arr){
         if(arr.length<2){
            throw new IllegalArgumentException("Array must have at least 2 elements");
         }
         int smallest=Integer.MAX_VALUE;
         int secondSmallest=Integer.MAX_VALUE;
         for (int i = 0; i < arr.length; i++) {
            if(arr[i]<smallest){
                secondSmallest=smallest;
                smallest=arr[i];
            }
            else if(arr[i]<secondSmallest && arr[i]!=smallest){
              secondSmallest=arr[i];
            }
         }
         return secondSmallest;
    }
    // Check the array is sorted or not
    // burte force we can loop form the 1 to n
    // Check the things in such way that arr[i] to arr[i-1]
    public static boolean isArraySorted(int []arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>=arr[i-1]){
              
            }
            else{ 
                return false;
            }
        }
        return true;
    }
    // remove the duplicates in place from sorted list
    public static int removeDuplicates(int arr[]){
        int i=0;
        // Two pointer approach
        for (int j = 0; j < arr.length; j++) {
            if(arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        // int arr[]=new int[4];
        // when we declare the array globally all feild with the value 0
        // Test case:
        // brute force solution
        // Better solution
        // optimial solution

        // largest element in the array
        int arr[]={5,2,9,10,182,90,22};
        largestInArray(arr);
        int secondLAndS[]=secondLargestElement(arr);
        System.out.println("Second largest element int the array:"+secondLAndS[0]);
        System.out.println("Second smallest element int the array:"+secondLAndS[1]);
        int a[]={1,2,3,4,5};
        System.out.println(isArraySorted(a));

    }
}