public class ReversePairs {
    // Hard problem 
    // Brute force
    // public static int reversePairs(int []arr){
    //     int count=0;
    //     for(int i=0;i<arr.length-1;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[i]>2*arr[j]){
    //                  count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // Optimal solution
    
    public static void main(String[] args) {
        int arr[]={40,25,19,12,9,6,2};
        // i <j && a[i]> 2*arr[j]
        // (6,2) (9,2) (12,2) (19,2) (25,2) (40,2)
        System.out.println(reversePairs(arr));

    }
}
