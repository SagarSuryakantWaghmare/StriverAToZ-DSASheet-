import java.util.*;
import java.util.List;

public class ThreeNumbersEven {
    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int count[] = new int[10];
        Arrays.stream(digits).forEach(x -> count[x]++);

        for (int i = 100; i < 1000; i++) {
            int temp[] = new int[10];
            for (int j = i; j>0; j = j / 10) {
                temp[j%10]++;
            }
            boolean flag = false;
            for(int k=0;k<10;k++){
                if(temp[k]>count[k]){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                res.add(i);
            }

        }

        return res.stream().mapToInt(x->x).toArray();
    }

    public class Main {
        public static void main(String[] args) {
            int[] digits = { 2, 1, 3, 0 };
            int[] result = findEvenNumbers(digits);

            System.out.println("Even 3-digit numbers that can be formed are:");
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }

}