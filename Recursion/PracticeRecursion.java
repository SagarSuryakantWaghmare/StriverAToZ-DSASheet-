public class PracticeRecursion {
    public static void firstSum(int n,int sum){
        if(n==0){
            System.out.println(sum);
            return;
        }
        firstSum(n-1, sum+n);
    }
    public static int firstSumFun(int n){
        if(n==0){
            return 0;
        }
        return n+firstSumFun(n-1);
    }
    public static void fact(int n,int fact){
        if(n==0){
            System.out.println(fact);
            return;
        }
        fact(n-1,fact*n);
    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        // First sum of n numbers
        // parameters
        // firstSum(10,0);

        // Functional
        // System.out.print(firstSumFun(10));

        // Factorial of the number parameter
        // fact(5,1);

        // Factorial using the functional
        System.out.println(fact(5));
    }
}