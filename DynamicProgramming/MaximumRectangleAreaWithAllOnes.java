public class MaximumRectangleAreaWithAllOnes {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };
        System.out.println("Maximum area of rectangle with all 1s: " + maxArea(matrix));
    }

    public static int maxArea(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = (matrix[i][j] == 0) ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? heights.length : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }

        return maxArea;
    }
}
