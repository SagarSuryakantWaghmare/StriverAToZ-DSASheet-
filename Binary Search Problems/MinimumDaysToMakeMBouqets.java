public class MinimumDaysToMakeMBouqets {
    public static boolean possible(int []arr,int day,int m,int k){
        int n=arr.length;
        int count=0;
        int noOfB=0;
        // Count the number of bouquets:
        for(int i=0;i<n;i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                noOfB+=(count/k);
                count=0;
            }
        }
        noOfB+=(count/k);
        return noOfB>=m;
    }
    public static int roseGarden(int[]arr,int k,int m){
        int val=m*k;
        int n=arr.length;
        if(val>n) return -1;
        // Finding the maximum and minimum
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini=Math.min(mini, arr[i]);
            maxi=Math.max(maxi, arr[i]);
        }

        // Apply binary Search
        int low=mini;
        int high=maxi;
        while (low<=high) {
            int mid=(low+high)/2;
            if(possible(arr,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[]={7,7,7,7,13,11,12,7};
        int k=3;
        int m=2;
        int ans=roseGarden(arr,k,m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    
    }
}
