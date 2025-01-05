public record MinimumElementBinarySearch() {
    public static int minimumSearch(int arr[]){
        int min=Integer.MAX_VALUE;
        int low=0;
        int high=arr.length-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                min=Math.min(min, arr[low]);
                low=mid+1;
            }
            else{
                high=mid-1;
                min=Math.min(min, arr[mid]);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[]={5,6,7,8,9,10,1,2,3,4};
        System.out.println(minimumSearch(arr));
    }
}
