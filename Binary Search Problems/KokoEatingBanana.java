public class KokoEatingBanana {
    public static int maxInArray(int []arr){
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi, arr[i]);
        }
        return maxi;
    }
    public static int Time(int mid, int arr[]) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += Math.ceil((double) arr[i] / mid); // Cast arr[i] to double
        }
        return total;
    }
    
    public static int minInteger(int arr[],int h){
        int low=1;
        int high=maxInArray(arr);
        int ans=0;
        while (low<=high) {
            int mid=low+(high-low)/2;
            int findHours=Time(mid,arr);
            if(findHours<=h){
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
        int[] arr = {7, 15, 6, 3};
        int h = 8;
        System.out.println(minInteger(arr,h));
    }
}
