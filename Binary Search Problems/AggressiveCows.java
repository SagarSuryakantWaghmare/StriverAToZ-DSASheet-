import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int dist,int arr[],int cows){
      int cow=0;
      int last=arr[0];
      for (int i = 1; i < arr.length; i++) {
        if(arr[i]-last>=dist){
            cow++;
            last=arr[i];
        }
        if(cow>=cows) return true;
      }
      return false;
    }
    public static int minDistanceMax(int arr[],int cows){
      int low=0;
      Arrays.sort(arr);
      int n=arr.length;
      int high=arr[n-1]-arr[0];
      while (low<=high) {
        int mid=(low+high)/2;
        if(canWePlace(mid,arr,cows)){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
      }
      return high;
    }

    public static void main(String[] args) {
        int arr[]={0,3,4,7,10,9};
        int cows=4;
        System.out.println(minDistanceMax(arr,cows));

    }
}