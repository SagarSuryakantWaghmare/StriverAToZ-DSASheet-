public class nextPermutation {
    public static int[] permutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // If the array is already the last permutation, return the first permutation
            int[] firstPermutation = new int[n];
            for (int i = 0; i < n; i++) {
                firstPermutation[i] = i + 1;
            }
            return firstPermutation;
        }

        int nextGreaterIndex = -1;
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                nextGreaterIndex = i;
                break;
            }
        }

        // Swap the elements at index and nextGreaterIndex
        int temp = arr[index];
        arr[index] = arr[nextGreaterIndex];
        arr[nextGreaterIndex] = temp;

        // Reverse the elements from index + 1 to the end
        int left = index + 1;
        int right = n - 1;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;
    }
    // Time complexity:O(3N)

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] ans = permutation(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}