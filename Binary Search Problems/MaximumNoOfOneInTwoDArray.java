public class MaximumNoOfOneInTwoDArray {
    public static int lowerBound(int arr[],int m,int target){
    int low=0;
    int high=arr.length-1;
    int ans=-1;
    while (low<=high) {
        int mid=(low+high)/2;
        if(arr[mid]<target){
           ans=mid;
           low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return ans;
    }
    public static int findRowWithMaxOne(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        int count_Max=0;
        int index=-1;
        for(int i=0;i<arr.length;i++){
            int count_Ones=m-lowerBound(arr[i],m,1);
            if(count_Ones>count_Max){
                count_Max=count_Ones;
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[][]={{0,1,1,1},{0,0,1,1},{1,1,1,1},{0,0,0,0}};
        System.out.println(findRowWithMaxOne(arr));
    }
}
