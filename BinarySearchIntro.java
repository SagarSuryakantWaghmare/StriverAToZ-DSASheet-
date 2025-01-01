public class BinarySearchIntro {
    // Iterative approach

    // public static int search(int []arr,int target){
    //     int low=0;
    //     int high=arr.length-1;
    //     while (low<high) {
    //         int mid=low+(high-low)/2;
    //         if(arr[mid]==target){
    //             return mid;
    //         }
    //         else if(arr[mid]<target){
    //             low=mid+1;
    //         }
    //         else{
    //             high=mid-1;
    //         }
    //     }
    //     return -1;
    // }
        // Recursive approach
        public static int  search(int []arr,int target){
            return helper(arr, target, 0, arr.length - 1);
        } 
        public static int helper(int[] arr, int target, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return helper(arr, target, mid + 1, high);
            } else {
                return helper(arr, target, low, mid - 1);
            }
        }
 public static void main(String[] args) {
    /*
     * Bineary Serach
     * Array is always sorted
     * int low=0, high=arr.length-1;
     * int mid=(low)+(high-low)/2;
     * if(arr[mid]==target) return mid;
     * if(arr[mid]<target) low=mid+1;
     * else high=mid-1;
     * 
     */
    int arr[]={2,4,7,9,14,19,24,28,39,10};
    System.out.println("Element present at "+search(arr,14));
    
 }
}
