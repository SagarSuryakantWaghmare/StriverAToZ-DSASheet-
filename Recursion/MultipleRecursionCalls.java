public class MultipleRecursionCalls {
    public static int fibo(int n){
        if(n<=1){
            return n;
            
        }
        int last=fibo(n-1);
        int slast=fibo(n-2);
        return last+slast;
    }
    public static void main(String[] args) {
        // Multiple recursion calls
        // Fibonacci numbers

        // 0 1 1 2 3 5 

        // We have to write a function to get the fibonacci
        System.out.println(fibo(5));
        // time complexity we have to call two at the time
        // so the time complexity about time complexity:(2^n)
    }
}
