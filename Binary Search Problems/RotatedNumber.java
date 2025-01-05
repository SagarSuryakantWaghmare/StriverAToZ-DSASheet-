public class RotatedNumber {
    public static int rotatedNumber(int arr[]){
        int low=0;
        int high=arr.length-1;
        int index=0;
        int min=Integer.MAX_VALUE;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min=arr[low];
                    index=low;
                }
                low=mid+1;
            }
            else{
                if(arr[mid]<min){
                    min=arr[mid];
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[]={3,4,5,1,2};
        System.out.println(rotatedNumber(arr));
    }
}
