import java.util.Scanner;

/**
 * SolvingPatterns
 */
public class SolvingPatterns {
    public static void print1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void print4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void print5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void print7(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void print8(int n) {

        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - (2 * i) - 1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void print9(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - (2 * i) - 1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void print10(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");

            }
            System.out.println();
        }
    }

    public static void print11(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void print12(int n) {
        for (int i = 1; i <= n; i++) {
            // numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= 2 * n - 2 * i; j++) {
                // space
                System.out.print(" ");

            }
            // numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j);

            }
            System.out.println();
        }

    }

    public static void print13(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" " + count++);
            }
            System.out.println();
        }
    }

    public static void print14(int n) {
        for (char i = 1; i <= n; i++) {
            for (char j = 'A'; j < 'A' + i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void print15(int n) {
        for (char i = 1; i <= n; i++) {
            for (char j = 'A'; j <= 'A' + n - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void print16(int n) {
        for (int i = 0; i < n; i++) {
            char ch = (char) ('A' + i); // Convert 'A' + i to a character
            for (int j = 0; j <= i; j++) {
                System.out.print(ch); // Print the character multiple times based on the row number
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    public static void print17(int n) {

        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print(" ");
            }
            // characters printing
            char ch = 'A';
            int breakPoint = (2 * i + 1) / 2;
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(ch);
                if (j < breakPoint) {
                    ch++;
                } else {
                    ch--;
                }
            }
            // Spaces
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void print18(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'E'; ch <= 'E' + i; ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void print19(int n) {

        int inis = 0;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            inis += 2;
            System.out.println();

        }
        inis = 8;
        for (int i = 1; i <= n; i++) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            inis -= 2;
            System.out.println();

        }

    }

    public static void print20(int n) {
        int spaces = 2 * n - 2;
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            // stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
            if (i < n)
                spaces -= 2;
            else
                spaces += 2;

        }
    }

    public static void print21(int n){
     for (int i = 0; i <n; i++) {
      for (int j = 0; j < n; j++) {
        if(i==0||j==0||i==n-1||j==n-1){
           System.out.print("*"); 
        }
        System.out.print(" ");
      } 
      System.out.println();
     }
    }
    public static void print22(int n){
        for (int i = 0; i <2*n-1; i++) {
            for (int j = 0; j <2*n-1; j++) {
                int top=i;
                int left=j;
                int right=(2*n-2)-j;
                int down=(2*n-2)-i;
                System.out.print(n-Math.min(Math.min(top,down),Math.min(left,right)));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // print1(n);
        // print2(n);
        // print3(n);
        // print4(n);
        // print5(n);
        // print6(n);
        // print7(n);
        // print8(n);
        // print9(n);
        // print10(n);
        // print11(n);
        // print12(n);
        // print13(n);
        // print14(n);
        // print15(n);
        // print16(n);
        // print17(n);
        // print18(n);
        // print19(n);
        // print20(n);
        // print21(n);
        print22(n);

    }
}