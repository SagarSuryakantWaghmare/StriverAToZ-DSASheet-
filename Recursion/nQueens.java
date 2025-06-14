import java.util.*;

public class nQueens {
    public static List<List<String>> solveNQueen(int n){
        List<List<String>> ls = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        solve(ls, board, 0);
        return ls;
    }

    public static void solve(List<List<String>> ls, char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder st = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    st.append(board[i][j]);
                }
                temp.add(st.toString());
            }
            ls.add(temp);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                solve(ls, board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        int n = board.length;

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> ls = solveNQueen(n);
        System.out.println(ls);
    }
}
