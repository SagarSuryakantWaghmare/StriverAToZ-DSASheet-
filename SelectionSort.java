import java.util.Scanner;

/**
 * SelectionSort
 */
public class SelectionSort {

    public static void main(String[] args) {
        // selection sort
        // 13 46 24 52 20 9
        // ascending order
        // get the minimum form the array
        // and then move again to the array to the next step
        // 9 46 24 52 20 13
        // 9 13 24 46 52 20
        // 9 13 20 46 52 24
        // 9 13 20 24 52 46
        // 9 13 20 24 46 52
        // Swaping going form the 0 to n-1
        // Swaping going form the 1 to n-1
        // Swaping going form the 2 to n-1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // selection_sort(arr, n);
        // bubble_sort(arr,n);
        Insertion_sort(arr,n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
     // Bubble sort
    // 13 46 24 52 20 9
    // Adjacent swaps
    // like 13<46
    // correct next to steps
    // 46 and 24 not correct swap them
    // 13  24 46  52 20 9
    // 13  24 46  20 52 9
    // 13  24 46  20 9 52
    // Here we see that the 52 max at the last
    // again stpes repeat

    private static void bubble_sort(int[] arr, int n) {
        // o(n^2)
       for (int i = n-1; i >=0; i--) {
         for (int j = 0; j < i-1; j++) {
            if(arr[j]>arr[j+1]){
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
         }
       }
    }

    private static void selection_sort(int[] arr, int n) {
        // O(n*n)
        for (int i = 0; i < n - 1; i++) {
            int minI = i;
            for (int j = i; j <= n - 1; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j;
                }
            }
            int temp = arr[minI];
            arr[minI] = arr[i];
            arr[i] = temp;
        }
    }
   
    // Insertion sort:
    // Takes a elements and put in the correct position
    public static void Insertion_sort(int[]arr,int n){
       for (int i = 0; i <=n-1; i++) {
        int j=i;
        while (j>0 && arr[j-1]>arr[j]) {
            int temp=arr[j-1];
            arr[j-1]=arr[j];
            arr[j]=temp;
            j--;
        }
       } 
    }

   



}