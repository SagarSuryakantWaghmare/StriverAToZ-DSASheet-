public class rotation {
    // public static void leftRotation(int []arr,int n){
        // for (int i = n; i < arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }
        // for (int i = 0; i < n; i++) {
        //     System.out.print(arr[i]+" ");
        // }
        // int temp=arr[0];
        // for (int i = 1; i < arr.length; i++) {
        //     arr[i-1]=arr[i];
        // }
        // arr[n-1]=temp;
    // }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int d=2;
        int n=arr.length;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        leftRotation(arr,n,d);
        System.out.println("After left rotation:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void leftRotation(int[] arr, int n, int d) {
       d=d%n;
       int temp[]=new int[d];
       for (int i=0;i<d;i++){
        temp[i]=arr[i];
       }
       for(int i=d;i<n;i++){
        arr[i-d]=arr[i];
       }
       for (int i = n-d; i < n; i++) {
        arr[i]=temp[i-(n-d)];
       }

    }
}
