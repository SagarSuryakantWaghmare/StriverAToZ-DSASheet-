import java.util.*;

public class StockSpanProblem {
    public static class StockSpanner {
        Stack<int[]> stack;  

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            // 100 80 60 70 60 75 85

            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                // 1 1 1 2 1 4 6
                span += stack.pop()[1]; 
            }
            stack.push(new int[]{price, span}); 
            return span;
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        StockSpanner spanner = new StockSpanner();

        for (int price : prices) {
            System.out.print(spanner.next(price) + " ");
        }
    }
}
