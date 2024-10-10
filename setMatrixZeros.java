public class setMatrixZeros {

    // Brute force approach


    // public static void markRow(int [][]matrix,int i){
    //     for (int j = 0; j < matrix.length; j++) {
    //         if(matrix[i][j]!=0){
    //             matrix[i][j]=-1;
    //         }
    //     }
    // }
    // public static void markCol(int [][]matrix,int j){
    //     for(int i=0;i<matrix.length;i++){
    //         if(matrix[i][j]!=0){
    //             matrix[i][j]=-1;
    //         }
    //     }
    // }
    // public static void setZeroes(int [][]matrix){
    //     int n=matrix.length;
    //     int m=matrix[0].length;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(matrix[i][j]==0){
    //                 markRow(matrix,i);
    //                 markCol(matrix,j);
    //             }
    //         }
    //     }

    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             if(matrix[i][j]==-1){
    //                 matrix[i][j]=0;
    //             }
    //         }
    //     }
    // }

    // Better solution:

    public static void setZeroes(int[][]matrix){

        int n=matrix.length;
        int m=matrix[0].length;
        // First make the two array 
        int row[]=new int[n];
        int col[]=new int[m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                     row[i]=1;
                     col[j]=1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i]==1||col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
   public static void main(String[] args) {
    int arr[][]={{1,0,1,1},{1,0,1,1},{1,1,1,1},{1,1,1,0}};
    System.out.println("matrix:");
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    System.out.println("Matrix after setting to zeros");

    setZeroes(arr);
    System.out.println("matrix:");
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
   } 
}
