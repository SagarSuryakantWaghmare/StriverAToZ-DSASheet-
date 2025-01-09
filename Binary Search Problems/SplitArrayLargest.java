public class SplitArrayLargest{
    public static int countPainter(int[]arr,int sum){
        int painter=1;
        int home=0;
        for (int i = 0; i < arr.length; i++) {
                if(arr[i]+home<=sum){
                    home+=arr[i];
                }
                else{
                    painter++;
                    home=arr[i];
                }
        }
        return painter;
    }
    public static int arrayLargest(int []arr,int k){
       int maxi=Integer.MIN_VALUE;
       int sum=0;
       for (int i = 0; i < arr.length; i++) {
        maxi=Math.max(maxi, arr[i]);
        sum+=arr[i];
       }
       int low=maxi;
       int high=sum;
       while (low<=high) {
        int mid=low+(high-low)/2;
        int painter=countPainter(arr,mid);
        if(painter>k){
            low=mid+1;
        }
        else{
           high=mid-1;
        }
       }
       return low;
    }

    public static void main(String[] args) {
        // painter partition
        int arr[]={10,20,30,40};
        int k=2;
        System.out.println(arrayLargest(arr,k));
    }
}