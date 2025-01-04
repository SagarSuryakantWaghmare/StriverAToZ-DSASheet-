import java.util.*;

public class RearrangeArrayElementsBySign {
    public static void rearrange(int[] arr) {
        int n = arr.length;
       
        List<Integer> pos = new LinkedList<>();
        List<Integer> neg = new LinkedList<>();
        
       
        for (int i : arr) {
            if (i >= 0) {
                pos.add(i);
            } else {
                neg.add(i);
            }
        }
        
       
        for (int i = 0; i < pos.size(); i++) {
            arr[i] = pos.get(i);
        }
        
      
        for (int i = 0; i < neg.size(); i++) {
            arr[pos.size() + i] = neg.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, -2, 3, -4};
        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("Rearranged:");
        rearrange(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
