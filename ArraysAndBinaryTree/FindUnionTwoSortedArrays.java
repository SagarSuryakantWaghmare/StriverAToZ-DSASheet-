import java.util.ArrayList;

public class FindUnionTwoSortedArrays {
    public static void main(String[] args) {
        int a1[] = {1, 1, 2, 3, 4, 4, 5};
        int a2[] = {2, 3, 4, 4, 4, 5, 6};

        // Optimal way using two pointers
        ArrayList<Integer> union = new ArrayList<>();
        int n1 = a1.length;
        int n2 = a2.length;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                // Add a1[i] if it's unique
                if (union.size() == 0 || union.get(union.size() - 1) != a1[i]) {
                    union.add(a1[i]);
                }
                i++;
            } else if (a1[i] > a2[j]) {
                // Add a2[j] if it's unique
                if (union.size() == 0 || union.get(union.size() - 1) != a2[j]) {
                    union.add(a2[j]);
                }
                j++;
            } else {
                // If both are equal, add one of them (a1[i] or a2[j])
                if (union.size() == 0 || union.get(union.size() - 1) != a1[i]) {
                    union.add(a1[i]);
                }
                i++;
                j++;
            }
        }

        // If there are remaining elements in a1
        while (i < n1) {
            if (union.size() == 0 || union.get(union.size() - 1) != a1[i]) {
                union.add(a1[i]);
            }
            i++;
        }

        // If there are remaining elements in a2
        while (j < n2) {
            if (union.size() == 0 || union.get(union.size() - 1) != a2[j]) {
                union.add(a2[j]);
            }
            j++;
        }

        // Print the result
        for (int num : union) {
            System.out.print(num + " ");
        }
    }
}
