import java.util.ArrayList;

public class mergeSort {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int a[], int low, int mid, int high) {
        ArrayList<Integer> arr=new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
           if(a[left]<a[right]){
            arr.add(a[left]);
            left++;
           }
           else{
            arr.add(a[right]);
            right++;
           }
        }
        while (left<=mid){
            arr.add(a[left]);
            left++;
        }
        while (right<=high){
            arr.add(a[right]);
            right++;
        }
        for (int i = low; i < high; i++) {
            a[i]=arr.get(i-low);
        }
        
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);

    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 2, 7, 9, 10, 15 };
        printArray(arr);
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}