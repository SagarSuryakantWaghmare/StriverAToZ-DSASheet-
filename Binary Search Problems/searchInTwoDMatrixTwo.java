public class searchInTwoDMatrixTwo {
    public static int[] search(int [][]arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        int row=0;
        int col=m-1;
        while (row<n||col>=0) {
            if(arr[row][col]==target){
                return new int[]{row,col};
            }
            else if(arr[row][col]<target){
                row++;
            }
            else{
                col--;
            }

        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int arr[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target=14;
        int ans[]=search(arr,target);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
