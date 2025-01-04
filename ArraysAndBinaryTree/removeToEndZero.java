public class removeToEndZero {
    public static int[] removeZero(int []arr){
        // Get the j postion where there is first zero aapears
        int j=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return arr;
        for (int i = j+1; i < arr.length; i++) {
            if(arr[i]!=0){
                swap(arr,i,j);
                j++;
            }
        }
        return arr;
    }
    public static void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0,4,5,7,0,9,0,4,3};
        int ans[]=removeZero(arr);
        for (int i : ans) {
            System.out.print(i+" ");
        }

    }
}
