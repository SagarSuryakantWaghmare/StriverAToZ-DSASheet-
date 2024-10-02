public class missingNumber {
    // time complexity:O(n)
    //space complexity:O(1)

    // public static int  missingnum(int []arr,int n){
    //     int actualSum=n*(n+1)/2;
    //     int sum=0;
    //     for (int i : arr) {
    //         sum+=i;
    //     }
    //     return actualSum-sum;
    // }

    // XOR
    public static int missingnum(int []arr,int N){
        int xor1=0;
        int xor2=0;
        int n=N-1;
        for (int i = 0; i < n; i++) {
            xor1=xor1^(i+1);
            xor2=xor2^arr[i];
        }
        xor1=xor1^N;
        return xor1^xor2;
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5};
        // two optimal solution
        int n=5;
        System.out.println(missingnum(arr,n));
    }
}
