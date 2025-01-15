public class FindPeakElementInTwoDArray {
    public static int[] findPeakElement(int [][]mat){
        int low=0;
        int n=mat.length;
        int m=mat[0].length;
        int high=m-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            int row=maxElement(mat,n,m,mid);
            int left=mid-1>=0? mat[row][mid-1]:-1;
            int right=mid+1<m? mat[row][mid+1]:-1;
            if(mat[row][mid]>left&&mat[row][mid]>right){
                return new int[]{row,mid};
            } else if (left > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1}; 
    }

    private static int maxElement(int[][] mat, int n, int m, int mid) {
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (mat[i][mid] > mat[maxIndex][mid]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int mat[][]={{10,8,10,10},
                     {14,13,12,11},
                     {15,9,11,21},
                     {16,17,19,20}};
        int[] peak = findPeakElement(mat);
        System.out.println("Peak element found at: (" + peak[0] + ", " + peak[1] + ")");
    }
}
