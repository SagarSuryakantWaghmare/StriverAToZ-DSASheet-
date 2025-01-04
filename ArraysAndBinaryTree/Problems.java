public class Problems {
    public static void f(int i, int arr[], int n) {
        if (i >= n / 2)
            return;
        swap(arr, i, n - i - 1);  // Pass the array and indices to the swap method
        f(i + 1, arr, n);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];  // Swap the elements in the array
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to check if a string is palindrome
    private static boolean isPalindrome(String s, int i) {
        int n = s.length();
        if (i >= n / 2) 
            return true;
        if (s.charAt(i) != s.charAt(n - i - 1))  // Compare characters at i and n-i-1
            return false;
        return isPalindrome(s, i + 1);  // Recursive call to check the next pair
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        f(0, arr, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        String s = "madam";
        System.out.println("Palindrome: " + isPalindrome(s, 0));
    }
}
