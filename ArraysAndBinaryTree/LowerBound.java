public class LowerBound {
    public static int searchLowerBound(int []arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int arr[]={3,5,8,15,19};
        int target=5;
        // arr[index]>=target
        System.out.println("Element present at "+searchLowerBound(arr,target));
        // Output: Element present at 2
    }
}
