import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        // Merge Sort
        // Divide and then get the answer
        int[] arr = { 26, 3, 4, 65, 7, 1, 6, 8, 90, 9 };
        int n = arr.length;
        mergeSort(arr, n);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        // Algorithm works on the divide and merge

    }

    public static void mergeSort(int[] arr, int n) {
        mergeS(arr, 0, n - 1);
        // Merge sort :Here we divide and the merge and then also we merge it.
        // First step:Divide the array and then sort.
        // Second step:Repeat the step while there is only one element in the array.
        // When at the last there is only one element in the array
        // Then simply compare and and merge in the sorted array.
        // And then go the next step and continue and atleast when get array.

        // pseudoCode
        // if(low>=high) return;
        // mid =low+(high-low)/2;
        // mergeSort(arr,low,mid);
        // mergeSort(arr,mid+1,high);
        // merge(arr,low,mid,high);

        // merge(arr,low,mid,high){
        /*
         * arr-[]
         * left=low;
         * right=mid+1;
         * while(left<=mid&& right<=high){
         * if(arr[left]<arr[right]){
         * temp.add(arr[left])
         * left++;
         * }}
         * else{
         * temp.add(arr[right]);
         * right++;}
         */
        // while (left<=mid) {
        // temp.add(arr[left]);
        // left++;
        // }
        // while (right<=right) {
        // temp.add(arr[right]);
        // right++;
        // }
        // }

    }

    public static void mergeS(int arr[], int low, int high) {
        if (low == high)
            return;
        int mid = low + (high - low) / 2;
        mergeS(arr, low, mid);
        mergeS(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
              temp.add(arr[left]);
              left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while (left<=mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right<=high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <=high; i++) {
            arr[i]=temp.get(i-low);
        }
    }
}
