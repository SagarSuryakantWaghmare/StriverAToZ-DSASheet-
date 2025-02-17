import java.util.Stack;

public class ImplementQueueUsingStack {
    static class QueueT {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        void push(int val) {
            st1.push(val); 
        }

        int pop() {
            if (st2.isEmpty()) {
                if (st1.isEmpty()) {
                    throw new RuntimeException("Queue is empty");
                }
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
            return st2.pop();
        }
    }

    public static void main(String[] args) {
        QueueT q = new QueueT();
        q.push(3);
        q.push(2);
        q.push(5);
        System.out.println(q.pop()); // 3
        System.out.println(q.pop()); // 2
        q.push(7);
        System.out.println(q.pop()); // 5
        System.out.println(q.pop()); // 7
    }
}
