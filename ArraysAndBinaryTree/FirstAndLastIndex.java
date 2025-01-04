public class FirstAndLastIndex {
    public static int[] search(int []arr,int target){
         int first=firstOccurrence(arr, target);
         if(first==-1){
             return new int[]{-1,-1};
         }
         int last=lastOccurence(arr, target);
    
        return new int[]{first,last};
    }
    public static int firstOccurrence(int []arr,int target){
        int low=0;
        int high=arr.length-1;
        int first=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]>target){
                high=mid-1;
            }
            else{
                 low=mid+1;
            }
            
        }
        return first;
    }
    public static int lastOccurence(int []arr,int target){
        int low=0;
        int high=arr.length-1;
        int last=-1;
        while(low<=high){
             int mid=low+(high-low)/2;
             if(arr[mid]==target){
                last=mid;
                low=mid+1;
             }
             else if(arr[mid]>target){
                high=mid-1;
             }
             else{
                low=mid+1;
             }
        }
        return last;
    }

    public static void main(String[] args) {
        int arr[]={2,4,6,8,8,11,13};
        int target=8;
        int result[]=search(arr,target);
        System.out.println("First Index: "+result[0]);
        System.out.println("Last Index: "+result[1]);
    }
    
}