import java.util.Stack;

public class AsteroidCollision {
    public static int[] Collision(int []asteroids){
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);  
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        
        int result[] = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int asteroids[] = {5, 10, -5};
        int[] pro = Collision(asteroids);
        for (int i : pro) {
            System.out.print(i + " ");
        }
    }
}
