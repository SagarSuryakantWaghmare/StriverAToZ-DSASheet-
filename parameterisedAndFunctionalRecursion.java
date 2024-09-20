public class parameterisedAndFunctionalRecursion {
    // sum of the number form 1 to n(parametrized)
    public static void sum(int s,int n){
        if(n<0){
            System.out.println(s);
            return;
        }
        sum(s+n, n-1);
    }
    // Functional :sum of the numbers.
    public static int sumF(int n){
        if(n==0) return 0;
        return n+sumF(n-1);
    }

    // Functional :factorial of the number
    public static int fact(int n){
        if(n==0) return 1;
        return n*fact(n-1);
    }

    public static void main(String[] args) {
        int n=10;
        // sum(0, n);
        System.out.println(sumF(n));
        System.out.println("Factorial of the number:"+fact(n));
    }
}
