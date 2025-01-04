public class FindUniqueNum {
    public static void main(String[] args) {
        int arr[]={1,1,2,3,3,4,4};
        // int maxi=arr[0];
        // // Hashing
        // for (int i = 0; i < arr.length; i++) {
        //     maxi=Math.max(arr[i], maxi);
        // }
        // int hash[]=new int[maxi+1];
        // for (int i = 0; i < arr.length; i++) {
        //     hash[arr[i]]++;
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     if(hash[arr[i]]==1){
        //         System.out.println(arr[i]);
        //     }
        // }

        // using xor
        int xorr=0;
        for (int i = 0; i < arr.length; i++) {
                xorr=xorr^arr[i];
        }
        System.out.println(xorr);
    }
}
