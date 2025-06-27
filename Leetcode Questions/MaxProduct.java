import java.util.Arrays;

public class MaxProduct {
    public static int maxProduct(int[]arr){
        Arrays.sort(arr);
        int n=arr.length;
        return arr[n-1]*arr[n-2];
    }

    public static void main(String[] args) {
        int arr[]={5,3,8,20,24,50};
        System.out.println("Max Product:"+maxProduct(arr));
    }
}