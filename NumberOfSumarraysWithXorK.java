public class NumberOfSumarraysWithXorK {
    // xor
    /*
     * 4^2 =6
     * 2^2^6=6
     * Brute force:6
     */
    // O(n^3)
    // public static int numberOfSumArray(int []nums,int k){
    //     int n=nums.length;
    //     int count=0;
    //     for (int i = 0; i < n; i++) {
    //         for(int j=i;j<n;j++){
    //             int xor=0;
    //             for (int l = i; l < j; l++) {
    //                xor=xor^nums[l]; 
    //             }
    //             if(xor==k){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // Better solution
    public static int numberOfSumArray(int []arr,int k){
        int count=0;
        for(int i=0;i<n;)
        return count;
    }
    public static void main(String[] args) {
        int []arr={4,2,2,6,4};
        int k=6;
        System.out.println(numberOfSumArray(arr, k));
        
    }
}
