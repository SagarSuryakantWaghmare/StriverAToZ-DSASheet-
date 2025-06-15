public class sudokoSolver {
    static int check=0;
    public static void sudokoSolver(char[][]board){
        solve(board,0,0);
        check=0;
    }

    public static void solve(char[][]board,int row,int col){
        if(row==9){
            check=1;
            return;
        }
        if(board[row][col]!='.'){
            if(col!=8) solve(board, row, col+1);
            else solve(board, row+1, 0);
        }
        else{
            for(char ch='1';ch<='9';ch++){
                if(isValid(board,row,col,ch)){
                    board[row][col]=ch;
                    if(col!=8) solve(board, row, col+1);
                    else solve(board, row+1, 0);
                    if(check==1) return;
                    board[row][col]='.';
                }
            }
        }
    }

    public static boolean isValid(char[][]board,int row,int col, char num){
        for (int i = 0; i < 9; i++) {
            if(board[row][i]==num){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if(board[i][col]==num){
                return false;
            }
        }
        int sRow=row/3*3;
        int sCol=col/3*3;
        for (int i = sRow; i < sRow+3; i++) {
            for (int j = sCol; j < sCol+3; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                    { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                    { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                    { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                    { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                    { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                    { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                    { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                    { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                    { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
            };

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("After Solving the sudoko");
    
            sudokoSolver(board);
    
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
    }
}