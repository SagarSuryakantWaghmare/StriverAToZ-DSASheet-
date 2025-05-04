import java.util.*;

public class DominoesEqual {
    public static int numEquivDominoPairs(int[][]dominoes){
        int count=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int []dom:dominoes){
            int a=Math.min(dom[0],dom[1]);
            int b=Math.max(dom[0],dom[1]);
            int key=a*10+b;
            int currCount=mp.getOrDefault(key, 0);
            count+=currCount;
            mp.put(key, count+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] dominoes = {
            {1, 2},
            {2, 1},
            {3, 4},
            {5, 6},
            {4, 3}
        };

        int result = numEquivDominoPairs(dominoes);

        System.out.println("Number of equivalent domino pairs: " + result);
    }
}