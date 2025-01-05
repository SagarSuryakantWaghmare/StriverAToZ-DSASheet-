public class SerachElementRotatedSorted {
    // here we don't directly do the array
    // Here duplicates are present
    public static int search(int []arr,int target){
        int low=0;
        int high=arr.length-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            if(arr[low]==arr[mid]&& arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            // left sorted
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target&& arr[mid]>=target){
                  high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(arr[mid]<=target&& arr[high]>=target){
                    low=mid+1;
                }
                else{
                      high=mid-1;
                  }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={7,8,1,2,3,3,3,4,4,6};
        int target=4;
        System.out.println(search(arr,target));
    }
}