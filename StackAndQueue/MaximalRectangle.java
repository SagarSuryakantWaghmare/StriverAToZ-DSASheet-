import java.util.Stack;

public class MaximalRectangle {
    // Histogram way
    public static int largestRectangle(int[]heights){
     int n=heights.length;
     int maxArea=0;
     Stack<Integer> st=new Stack<>();
     for (int i = 0; i <=n; i++) {
        int h=(i==n)?0:heights[i];
        while (!st.isEmpty()&&h<heights[st.peek()]) {
            int height=heights[st.pop()];
            int weight=st.isEmpty()?i:i-st.peek()-1;
            maxArea=Math.max(maxArea, height*weight);
        }
        st.push(i);
     }
     return maxArea;
    }
    public static int maximalRectangle(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        int preSum[][]=new int[n][m];
        int maxArea=0;
        if(n==0) return 0;
        // PreSum for the largest Histogram
        for (int i = 0; i <m; i++) {
            int sum=0;
            for(int j=0;j<n;j++){
                if(arr[j][i]==1){
                    sum++;
                }
                else{
                    sum=0;
                }
                preSum[j][i]=sum;
            }
        }
        // Finding the max Area of the rectangle
        for (int i = 0; i < n; i++) {
          maxArea=Math.max(maxArea, largestRectangle(preSum[i]));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int arr[][] = {
            { 1, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 1, 0, 0, 1, 0 }
        };
        System.out.println(maximalRectangle(arr));
    }
}