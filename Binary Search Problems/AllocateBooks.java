public class AllocateBooks {
    public static int countStud(int[] arr, int pages) {
        int stud = 1;
        int pagesStudent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= pages) {
                pagesStudent += arr[i];
            } else {
                stud++;
                pagesStudent = arr[i];
            }
        }
        return stud;
    }

    public static int allocate(int arr[], int students) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }
        int low = maxi;
        int high = sum;
        if (arr.length < students) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int stud = countStud(arr, mid);
            if (stud > students) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 25, 46, 28, 49, 24 };
        int students = 4;
        System.out.println(allocate(arr, students));
    }
}
