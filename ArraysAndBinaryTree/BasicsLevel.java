import java.util.HashMap;
import java.util.Scanner;

public class BasicsLevel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input size of array
        System.out.println("Enter the n:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        // Input elements in array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Precompute frequency of elements
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        
        // Process queries
        System.out.println("Enter the number of queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            System.out.println("Enter the number:");
            int number = sc.nextInt();
            
            // Output the count of the number
            System.out.println("Count of " + number + ": " + mp.getOrDefault(number, 0));
        }

        sc.close();
    }
}
