public class SearchInRotated{
    public static int search(int[]arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            else{
                // Left Sorted
                if(arr[low]<=arr[mid]){
                    if(arr[low]<=target&&arr[mid]>=target){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
                // right Sorted
                else{
                    if(arr[mid]<=target&&arr[high]>=target){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,8,1,2,3};
        System.out.println("Search in rotated Array:"+search(arr,8));
    }
}