public class SingleElement {
    public static int singleElement(int arr[]){
        if(arr.length==1) return arr[0];
        int low=1;
        int high=arr.length-2;
        if(arr[low-1]!=arr[low]){
            return arr[low];
        }
        if(arr[high-2]!=arr[high-1]){
            return arr[high];
        }
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(arr[mid]!=arr[mid-1]&&arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            if(mid%2==1&&arr[mid]==arr[mid-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,2,3,3,4,4,5,6,6,7,7,8,8};
        System.out.println(singleElement(arr));
    }
}
