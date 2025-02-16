import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    static class st{
        Queue<Integer> q=new LinkedList<>();
        void push(int val){
           int s=q.size();
           q.offer(val);
           for (int i = 0; i < s; i++) {
            q.offer(q.poll());
           } 
        }
        int pop(){
            return q.poll();
        }
        boolean isEmpty(){
            return q.isEmpty();
        }
    }
    public static void main(String[] args) {
        st s=new st();
        s.push(4);
        s.push(14);
        s.push(40);
        s.push(24);
        System.out.println(s.pop());
    }
}
