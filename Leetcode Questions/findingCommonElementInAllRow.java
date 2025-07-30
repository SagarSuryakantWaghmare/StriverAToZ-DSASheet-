import java.util.*;

public class findingCommonElementInAllRow {
    public static int findCommon(int mat[][]) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int num = mat[i][0];
            if (mp.containsKey(num)) {
                mp.put(num, mp.get(num) + 1);
            } else {
                mp.put(num, 1);
            }
            for (int j = 1; j < m; j++) {
                int curr = mat[i][j];
                int prevNum = mat[i][j - 1];
                if (curr != prevNum) {
                    if (mp.containsKey(curr)) {
                        mp.put(curr, mp.get(curr) + 1);
                    } else {
                        mp.put(curr, 1);
                    }
                }
            }
        }
        // Get all the if get values form the map is equal to rows then return that number
        for(Map.Entry<Integer,Integer> ele:mp.entrySet()){
           if(ele.getValue()==n){
            return ele.getKey();
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4, 5 },
                { 2, 4, 5, 8, 10 },
                { 3, 5, 7, 9, 11 },
                { 1, 3, 5, 7, 9 } };
        int result = findCommon(mat);
        if (result == -1)
            System.out.println("No common element");
        else
            System.out.println("Common element is " + result);
    }
}
