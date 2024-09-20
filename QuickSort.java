public class QuickSort {
   public static void main(String[] args) {
    // 1 st element in the array
    // pivot :Choose the first
    // And arrange the elements in such way that the 
    // the smaller than the pivot in the left side
    // the larger than the pivot in the right side
    int arr[]={4,2,1,5,3};
    quickSort(arr);
   }

private static void quickSort(int[] arr) {
    qs(arr,0,arr.length-1);
    for (int i : arr) {
        System.out.print(i+" ");
    }

}

private static void qs(int[] arr, int low, int high) {
    if(low<high){
        int pIndex=partition(arr,low,high);
        qs(arr, low, pIndex-1);
        qs(arr, pIndex+1, high);
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot=arr[low];
    int i=low;
    int j=high;
    while (i<j) {
        while (arr[i]<=pivot&& i<=high-1) {
            i++;
        }
        while (arr[j]>pivot&&j>=low+1) {
            j--;
        }
        if(i<j) swap(arr,i,j);
    }
    swap(arr, low, j);
    return j;
}

private static void swap(int[] arr, int i, int j) {
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
} 
}
