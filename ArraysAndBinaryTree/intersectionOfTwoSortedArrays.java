import java.util.*;
/**
 * intersectionOfTwoSortedArrays
 */
public class intersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int a1[] = {1, 2, 3, 3, 4, 5, 6};
        int a2[] = {1, 2, 3, 4, 5, 6};

        findIntersection(a1, a2);
    }

    public static void findIntersection(int[] a1, int[] a2) {
        int i = 0, j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] == a2[j]) {
                // To avoid duplicates
                if (i == 0 || a1[i] != a1[i - 1]) {
                    System.out.print(a1[i] + " ");
                }
                i++;
                j++;
            } else if (a1[i] < a2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}
