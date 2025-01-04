import java.util.*;;

public class BasicMath {
    public static int noOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int reverseInteger(int n) {
        int result = 0;
        while (n > 0) {
            int lastdigit = n % 10;
            result = result * 10 + lastdigit;
            n /= 10;
        }
        return result;
    }

    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int num = n;
        while (n > 0) {
            int last = n % 10;
            reverse = reverse * 10 + last;
            n /= 10;
        }
        if (num == reverse) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isArmonstrong(int n) {
        int num = n;
        int newNum = 0;
        while (n > 0) {
            int lastNum = n % 10;
            newNum += lastNum * lastNum * lastNum;
            n /= 10;
        }
        if (newNum == n) {
            return true;
        } else {
            return false;
        }
    }

    // Print all the divisons of numbers
    public static void printAllDivsions(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void printDivisors(int n) {
        Set<Integer> ne = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                ne.add(i);
                if ((n / i) != i) {
                    if (ne.contains(n / i)) {
                        continue;
                    }
                    ne.add(n / i);
                }
            }
            for (int j = 1; j < ne.size(); j++) {
                System.out.print(j + " ");
            }

        }

    }

    // Prime number check
    public static boolean isPrimeNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
    public static boolean isPrime(int n){
        int count=0;
        for (int i = 1; i*i <=n; i++) {
            if(n%i==0){
                count++;
                if((n/i)!=i) count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
    // Gcd /Hcf
    // we start form the end traverse and then go to the first
    public static int  GCD(int a,int b){
    //   Euclidean algorithm
    // gcd(n1,n2)=gcd(n1-n2,n2);
    while (a>0&& b>0) {
        if(a>b) a=a%b;
        else b=b%a;
    }
    if(a==0) return b;
    return a;
    }

    public static void main(String[] args) {
        // int n = 1441;
        // int n=1634;
        // System.out.println("No of digits in the number:" + noOfDigits(n));
        // System.out.println("Reverse the integer:"+reverseInteger(n));
        // System.out.println("Given number is palindrome:"+isPalindrome(n));
        // System.out.println("Given number is an Armstrong number:"+isArmonstrong(n));
        // int n = 40;
        // System.out.println("Divsions of the number:");
        // printAllDivsions(n);
        // printDivisors(n);
        // int n=37;
        // System.out.println("Given number is a prime number:"+isPrimeNumber(n));
        // System.out.println(isPrime(n));
        int n=16;
        int m=32;
        System.out.println(GCD(n,m));

    }
}
