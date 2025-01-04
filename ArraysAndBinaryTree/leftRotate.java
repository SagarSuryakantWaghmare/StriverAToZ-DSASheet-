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
    public static void leftRotate(int[]arr,int n,int d){
        d=d%n;
        int temp[]=new int[d];
        for (int i = 0; i < d; i++) {
            temp[i]=arr[i];
        }
        for (int i = d; i < n; i++) {
            arr[i-d]=arr[i];
        }
        for(int i=n-d;i<n;i++){
            arr[i]=temp[i-(n-d)];
        }
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
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Left rotated");
        leftRotate(arr, n, 2);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}