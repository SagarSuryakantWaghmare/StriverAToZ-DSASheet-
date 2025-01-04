/**
 * selectionSortG
 */
public class selectionSortG {
    public static int select(int []arr,int i){
        int minIndex=i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[minIndex]){
                minIndex=j;
            }
        }
        return minIndex;
    }
    public static void selectionSort(int arr[],int n){
        for(int i=0;i<n-1;i++){
            int minIndex=select(arr,i);
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int []arr={3,1,8,10,2};
        int n=5;
        selectionSort(arr,n);
    }
}
