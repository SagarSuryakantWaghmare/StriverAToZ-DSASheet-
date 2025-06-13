import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> generateSubsets(int[]arr){
        List<List<Integer>> ls=new ArrayList<>();
        generate(0,arr,new ArrayList<>(),ls);
        return ls;
    }

    public static void generate(int idx,int[]a,List<Integer> ds,List<List<Integer>> ls){
        ls.add(new ArrayList<>(ds));
        for(int i=idx;i<a.length;i++){
            ds.add(a[i]);
            generate(i+1, a, ds, ls);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println("Subsets of the array:");
        List<List<Integer>> subsets=generateSubsets(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        
    }
}