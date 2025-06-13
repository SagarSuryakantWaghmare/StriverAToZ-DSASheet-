public class QuickSort{
    public static void printList(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    public static void QuickSort(int[]arr,int low,int high){
        // 1 st element in the array
        //2 nd last element in the array
        // median of the array
        // random of the array

        //pivot & please it in its correct please int the sorted array.
        
    }
    public static void main(String[] args) {
       int arr[]={4,6,2,5,7,9,1,3};
       printList(arr);
       QuickSort(arr, 0, arr.length - 1);
       printList(arr);

    }
}