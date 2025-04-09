public class FloodFillAlgo {
    public static int[][]floodFill(int[][]image,int sr,int sc,int newColor){
        int currentColor=image[sr][sc];
        if(currentColor!=newColor){
            fill(image,sr,sc,currentColor,newColor);
        }
        return image;
    }
    public static void fill(int[][]image,int row,int col,int currentColor,int newColor){
        // So cases of the out of the bound and other colors
        if(row<0||row>=image.length||col<0||col>=image[0].length||image[row][col]!=currentColor){
            return;
        }
        image[row][col]=newColor;

        // now go for the 4 directions
        fill(image, row-1, col, currentColor, newColor);//up
        fill(image, row+1, col, currentColor, newColor);//down
        fill(image, row, col-1, currentColor, newColor);//left
        fill(image, row, col+1, currentColor, newColor);//right
    }
    public static void main(String[] args) {
        // Some in this problem it goes only in the 4 directions
        // 1. Up
        // 2. Down
        // 3. Left
        // 4. Right
        int [][]image={
        {1,1,1},
        {1,1,0},
        {1,0,1}
        };
        int sr=1;
        int sc=1;
        int newColor=2;
        int ans[][]=floodFill(image,sr,sc,newColor);
    }
}
