/**
 * leftRotate
 */
public class leftRotate {
    public static int[] leftRotateByOne(int[]arr,int n){
     int temp=arr[0];
     for (int i = 1; i < arr.length; i++) {
        arr[i-1]=arr[i];
     }
     arr[n-1]=temp;
     return arr;
    }
    public static int[] leftRotate(int[]arr,int n){
        
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int n=arr.length;
        // one left rotation
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // int larr[]=leftRotateByOne(arr,n);
        // for (int i : larr) {
        //     System.out.print(i+" ");
        // }
    }
}