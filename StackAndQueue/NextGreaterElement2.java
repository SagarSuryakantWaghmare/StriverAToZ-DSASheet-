import java.util.Stack;

public class NextGreaterElement2 {
    // private static int[] nextGreatest(int[] arr) {
    //     int nge[]=new int[arr.length];
    //     for (int i = 0; i < arr.length; i++) {
    //         nge[i]=-1;
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = i+1; j <i+arr.length; j++) {
    //             int index=j%arr.length;
    //             if(arr[index]>arr[i]){
    //                 nge[i]=arr[index];
    //                 break;
    //             }

    //         }
    //     }
    //     return nge;
    // }

    //optimal Solution
    private static int[] nextGreatest(int[] arr) {
        // monotonic stack
        int nge[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            nge[i]=-1;
        }
        // Hypothatic double the array
        int n=arr.length;
        for(int i=2*n-1;i>=0;i--){
            int index=i%n;
            while (!st.isEmpty() && st.peek() <= arr[index]) {
                st.pop();
            }           
            if(i<n){
               if(!st.isEmpty()){
                nge[i]=st.peek();
               }
            }
            st.push(arr[index]);
        }
        return nge;
    }
    public static void main(String[] args) {
        int arr[] = { 2,10,12,1,11 };
        // 10 12 -1 11 12
        // it is circular 
        System.out.println("Array is as follows");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Next greatest element of the array:");
        int nge[] = nextGreatest(arr);
                for (int i : nge) {
                    System.out.print(i + " ");
                }
            }
        
           
}
