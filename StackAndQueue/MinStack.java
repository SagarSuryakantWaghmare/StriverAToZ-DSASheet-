import java.util.Stack;

public class MinStack {
    public static class MinStackImpl {
        Stack<Integer> st = new Stack<>();
        int mini = Integer.MAX_VALUE;

        void push(int val) {
            if (st.isEmpty()) {
                mini = val;
                st.push(val);
            } else {
                if (val > mini) {
                    st.push(val);
                } else {
                    st.push(2 * val - mini);
                    mini = val;
                }
            }
        }

        int pop() {
            if (st.isEmpty()) {
                return -1; // Stack underflow
            }
            int x = st.pop();
            if (x < mini) {
                int original = mini;
                mini = 2 * mini - x;
                return original;
            }
            return x;
        }

        int top() {
            if (st.isEmpty()) {
                return -1;
            }
            int x = st.peek();
            return (x < mini) ? mini : x;
        }

        int getMin() {
            if (st.isEmpty()) {
                return -1;
            }
            return mini;
        }
    }

    public static void main(String[] args) {
        MinStackImpl minStack = new MinStackImpl();
        minStack.push(5);
        minStack.push(2);
        minStack.push(8);
        minStack.push(1);
        
        System.out.println("Minimum: " + minStack.getMin()); // Should be 1
        System.out.println("Top: " + minStack.top()); // Should be 1
        System.out.println("Popped: " + minStack.pop()); // Should be 1
        System.out.println("Minimum after pop: " + minStack.getMin()); // Should be 2
    }
}
