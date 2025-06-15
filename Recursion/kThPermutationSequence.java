import java.util.*;

public class kThPermutationSequence {
    public static String getPermutations(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        StringBuilder str = new StringBuilder();
        k = k - 1; // zero-based index

        while (!numbers.isEmpty()) {
            int index = k / fact;
            str.append(numbers.get(index));
            numbers.remove(index);

            if (numbers.isEmpty()) break;

            k %= fact;
            fact /= numbers.size();
        }

        return str.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        String ans = getPermutations(n, k);
        System.out.println(ans); // Output: "213"
    }
}
