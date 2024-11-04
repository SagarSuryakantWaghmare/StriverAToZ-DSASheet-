import java.util.HashMap;

public class MissingAndRepatingNumber {
    // public static int[] missingAndRepatingNumber(int arr[],int n){
    // int[]result=new int[2];
    // for(int i=1;i<=arr.length;i++){
    // int count=0;
    // for(int j=0;j<=arr.length-1;j++){
    // if(arr[j]==i){
    // count++;
    // }
    // }
    // if(count==2) result[0]=i;
    // if(count==0) result[1]=i;
    // }
    // return result;
    // }

    // Using the hasharray
    // public static int[] missingAndRepatingNumber(int []arr,int n){
    // HashMap<Integer,Integer> mp=new HashMap<>();
    // int repeating=-1;
    // int missing=-1;
    // int count=1;
    // int[]res=new int[2];
    // for(int i=0;i<arr.length;i++){
    // mp.put(count++, arr[0]);
    // }
    // for(int i=0;i<=n;i++){
    // if(mp.get(i)==2) repeating=i;
    // else if(mp.get(i)==0) missing=i;
    // if(repeating!=-1&&missing!=-1){
    // break;
    // }
    // }
    // res[0]=missing;
    // res[1]=repeating;
    // return res;
    // }

    // finding using the math

    public static int[] missingAndRepatingNumber(int arr[], int n) {
        int[] result = new int[2];
        int sum = 0;
        int sumOfSquares = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sumOfSquares += arr[i] * arr[i];
        }
        int sumOfN = n * (n + 1) / 2;
        int sumOfSquaresOfN = n * (n + 1) * (2 * n + 1) / 6;
        int diff = sum - sumOfN;
        int diffOfSquares = sumOfSquares - sumOfSquaresOfN;
        int sumOfBoth = diffOfSquares / diff;
        result[0] = (diff + sumOfBoth) / 2;
        result[1] = (sumOfBoth - result[0]);
        return result;
    }


    

    public static void main(String[] args) {
        int arr[] = { 4, 3, 6, 2, 1, 1 };
        int n = 6;
        int[] ans = missingAndRepatingNumber(arr, n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}