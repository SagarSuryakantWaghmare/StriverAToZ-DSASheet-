public class RotateImage {

    // Brute force approach:
    // ans[j][n-1-i]=matrix[i][j]
    // tc ans sc is O(n^2)

    // So we get ans

    public static void rotate(int [][]matrix){
        // first simply transpose the matrix
        // And then reverse the matrix
        int n=matrix.length;
        for (int i = 0; i <n; i++) {
            for (int j = i; j < n; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int i = 0; i <n; i++) {
            reverseInPlace(matrix[i]);
        }
    }
    public static void reverseInPlace(int[]matrix){
       int i=0,j=matrix.length-1;
       while (i<j) {
        int temp=matrix[i];
        matrix[i]=matrix[j];
        matrix[j]=temp;
        i++;
        j--;
       }

    }
    public static void main(String[] args) {
        int[][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        rotate(matrix);
        System.out.println("Rotate Image:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
