import java.util.Stack;

public class NextGreaterElement {
    // Monoatomic stack
    // When we store numbers in the array in the specific order then it is called as
    // the monoatomic stack
    // public static int[] nextGreatest(int []arr){
    // int nge[]=new int[arr.length];
    // for (int i = 0; i < nge.length; i++) {
    // nge[i]=-1;
    // }
    // for (int i = 0; i < arr.length-1; i++) {
    // for (int j = i+1; j < arr.length; j++) {
    // if(arr[i]<arr[j]){
    // nge[i]=arr[j];
    // break;
    // }
    // }
    // }
    // return nge;
    // }

    private static int[] nextGreatest(int[] arr) {
        // optimal solution
        int nge[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 0, 8, 1, 3 };
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
