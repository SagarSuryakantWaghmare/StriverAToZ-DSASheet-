import java.util.*;

public class CombinationSum2 {
    public static void combinationSum(int[]candidates,int target,Set<List<Integer>> ls,int index,List<Integer> ds){
     if(index==candidates.length){
        if(target==0){
            ls.add(new ArrayList<>(ds));
        }
        return;
     }

     if(candidates[index]<=target){
        ds.add(candidates[index]);
        combinationSum(candidates, target-candidates[index], ls, index+1, ds);
        ds.remove(ds.size()-1);
     }
     combinationSum(candidates, target, ls, index+1, ds);
    }
    public static List<List<Integer>> combinationSum(int[]candidates,int target){
      Set<List<Integer>> ls=new HashSet();
      combinationSum(candidates, target,ls,0,new ArrayList<>());
      List<List<Integer>> ans=new ArrayList<>(ls);
      return ans;
    }
    public static void main(String[] args) {
        // Given an array of integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        /*
         * For arr[]={1,1,1,2,2} and target=4
         * The output should be [[1,1,2],[1,2,1],[2,1,1]]
         */
        List<List<Integer>> ls=combinationSum(candidates,target);
        System.out.println(ls);
    }
}
