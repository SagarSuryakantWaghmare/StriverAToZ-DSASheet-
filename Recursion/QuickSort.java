public class QuickSort{
    public static void printList(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int partition(int[]arr,int low,int high){
        // Getting the pivot element
        int pivot=arr[high];
        // Index of smaller element
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                // Swap arr[i] and arr[j]
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;                                  




    }
    public static void QuickSort(int[]arr,int low,int high){
        // 1 st element in the array
        //2 nd last element in the array
        // median of the array
        // random of the array

        //pivot & please it in its correct please int the sorted array.
        
        if(low<high){
            int pivot=partition(arr,low,high);
            QuickSort(arr, low, pivot - 1); 
            QuickSort(arr, pivot + 1, high);

        }

    }
    public static void main(String[] args) {
       int arr[]={4,6,2,5,7,9,1,3};
       printList(arr);
       QuickSort(arr, 0, arr.length - 1);
       printList(arr);

    }
}