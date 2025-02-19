public class PreviousSmallerElement {
    public static void printArray(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] nearestSmallest(int[]arr){
        int n=arr.length;
        int[]nse=new int[n];
        for (int i = 0; i < nse.length; i++) {
            nse[i]=-1;
        }
        for (int i = 0; i < n; i++) {
          for(int j=i-1;j>=0;j--){
            if(arr[j]<arr[i]){
                nse[i]=arr[j];
                break;
            }
          }  
        }
        return nse;
    }
    public static void main(String[] args) {
        int arr[]={4,5,2,10,8};
        // -1 4 -1 2 5
        printArray(arr);
        System.out.println("Nearest Smallest Element:");
        int nse[]=nearestSmallest(arr);
        printArray(nse);
    }
}