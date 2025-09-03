public class Findmaximumheightpyramid{
    public static int findMaxHeight(int []arr){
        int n=arr.length;
        int s=0;
        int e=n;
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            int cal=mid*(mid+1)/2;
            if(cal<=n){
                ans=mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[]args){
        int arr[]={10,20,30,40,50,60,70};
        System.out.println(findMaxHeight(arr));
    }
}