import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        int nums[]={1,2,2};
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        backtrack(nums,ls,new ArrayList<>(),0);
        System.out.println(ls);
    }
    public static void backtrack(int a[],ArrayList<ArrayList<Integer>> ls,ArrayList<Integer> ds,int idx){
        ls.add(new ArrayList<>(ds));
        for(int i=idx;i<a.length;i++){
            if(i!=idx&&a[i]==a[i-1]) continue;
            ds.add(a[i]);
            backtrack(a, ls, ds, i+1);
            ds.remove(ds.size()-1);
        }

    }
}
