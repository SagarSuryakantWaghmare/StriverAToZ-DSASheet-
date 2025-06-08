/*
 * Recursion:
 * When a function calls itself until a specific condition is met.
 */
public class RecursionTree {
    public static void print(int n){
        if(n==0){
            return ;
        }
        print(n-1);
        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        print(5);
    }
}