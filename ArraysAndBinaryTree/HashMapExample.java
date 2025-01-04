import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a scanner object for input
        Scanner sc = new Scanner(System.in);
        
        // Input the number of elements in the array
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        
        // Create an array of size n
        int arr[] = new int[n];
        
        // Input the array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Create a HashMap to store elements and their frequencies
        Map<Integer, Integer> mp = new HashMap<>();
        
        // Fill the map with array elements and their frequencies
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1); // Increment the count if the element is already in the map
            } else {
                mp.put(arr[i], 1); // Add the element with a count of 1 if it's not in the map
            }
        }
        
        // Print the map
        System.out.println("Element frequencies:");
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
