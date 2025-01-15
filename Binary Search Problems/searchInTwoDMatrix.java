public class searchInTwoDMatrix {
    // public static boolean search(int [][]arr,int target){
    //     int n=arr.length;
    //     int m=arr[0].length;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(arr[i][j]==target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    public static boolean search(int [][]arr,int target){
        int n=arr.length;
        int m=arr[0].length;
      int low=0;
      int high=n*m-1;
      while (low<=high) {
        int mid=low+(high-low)/2;
        int midEle=arr[mid/m][mid%m];
        if(midEle==target){
            return true;
        }
        else if(midEle>target){
            high=mid-1;
        }
        else{
            low=mid+1;
        }
      }  
        return false;
    }

    public static void main(String[] args) {
        int arr[][]={{3,4,7,9},{12,13,14,18},{20,21,23,25}};
        int target=24;
        System.out.println(search(arr,target));
    }
}