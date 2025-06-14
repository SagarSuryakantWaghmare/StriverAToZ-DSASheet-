import java.util.*;

public class PrintAllPermutations {
    public static void recurPermute(int[]nums,List<Integer> ds,List<List<Integer>>ls,boolean[]freq){
        if(ds.size()==nums.length){
            ls.add(new ArrayList<>(ds));
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ls, freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
    public static List<List<Integer>> permute(int[]nums){
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        recurPermute(nums,ds,ls,freq);
        return ls;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        List<List<Integer>> ans=permute(nums);
        System.out.println(ans);
    }
}
