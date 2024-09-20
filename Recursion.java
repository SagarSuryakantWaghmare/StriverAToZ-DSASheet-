// When a function calls itself until a specifical condition is met.
/**
 * Recursion
 */
public class Recursion {
    // when there is unlimited calls in the recursion then there is a stack overflow.
    public static void recursion(int n){
        if(n>10) return;
        System.out.print(n+" ");
        n++;
       recursion(n);
    }
    // Print name 5 times
    public static void printName(int n){
        //base case
       if(n<0) return;
       //general case
       System.out.println("Sagar");
       n--;
       printName(n);
    }
    // Print linearly 1 to n
    public static void printNum(int i,int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        printNum((i+1),n);
    }
    // reverse num
    public static void reversePrintNum(int i,int n){
       if(i<1){
        return;
       }
       System.out.println(i);
       reversePrintNum(i-1,n);
    }
    // print linearly form 1 to n (but by backTrack)
    // backtrack:1 to n
    public static void printBacktrack(int n){
        // base case
        if(n<1) return;
        printBacktrack(n-1);
        System.out.println(n);
    }

     // backtrack:n to 1
     public static void printBacktrackR(int i,int n){
        // base case
        if(i>n) return;
        printBacktrackR(i+1,n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        // recursion(1);
        // printName(5);
        // printNum(1, 5);
        // reversePrintNum(5, 1);
        // printBacktrack(10);
        printBacktrackR(1,10);

    }
}