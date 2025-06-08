public class BasicsRecursionProblem {
    public static void printName(String s,int c){
        if(c==5){
            return;
        }
        System.out.println(s);
        printName(s, c+1);
    }

    // 1 to n
    public static void printNumber(int n,int i){
        if(i>8){
            return;
        }
        System.out.print(i+" ");
        printNumber(n,i+1);

    }

    public static void printReverse(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printReverse(n-1);
    }
    public static void printBackTrack(int i,int n ){
      if(i<1){
        return ;
      }  
      printBackTrack(i-1, n);
      System.out.print(i+" ");
    }

    public static void printRevBack(int n,int i){
        if(i>8){
            return;
        }
        printRevBack(n, i+1);
        System.out.print(i+" ");
    }
    public static void main(String[] args) {
        // Print names 5 times
        // printName("Sagar",0);

        // print linearly from 1 to n
        // printNumber(8,1);

        // Print in the reverse way 
        // printReverse(8);

        // Print linearly from 1 to N (Backtrack)
        // printBackTrack(8,8);

        // Backtrack n to 1
        printRevBack(8,1);
    }
}
