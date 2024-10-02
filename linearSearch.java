public class linearSearch {
    public static int firstOccurence(int []arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={6,7,8,4,1};
        // Finding the first index of that number
        int target=8;
        System.out.println(firstOccurence(arr,target));

    }
}
