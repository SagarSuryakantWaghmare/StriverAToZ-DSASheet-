public class SimpleFibonacciRecursion {
    // Fibonacci series using simple recursion
    public static int f(int n) {
        if (n <= 1) return n; // Base cases: f(0) = 0, f(1) = 1
        return f(n - 1) + f(n - 2); // Recursive case: sum of the two previous numbers
    }

    public static void main(String[] args) {
        int n = 10; // Find the 10th Fibonacci number
        for (int i =0; i <n; i++) {
            
            System.out.print(f(i)+" ");
        }

    }
}
