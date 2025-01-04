import java.util.ArrayList;

public class SpiralMatrix {
    public static ArrayList spiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (top<=bottom&&left<=right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        ArrayList ans = spiral(matrix);
        System.out.println(ans);

    }
}
