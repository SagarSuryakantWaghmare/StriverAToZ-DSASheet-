import java.util.ArrayList;
import java.util.List;

public class subsequencesPrinting {    public static void subseq(int[]a,List<Integer> ls,int idx){
        if(idx>=a.length){
            System.out.println(ls);
            return;
        }
        // Include the current element
        ls.add(a[idx]);
        subseq(a, ls, idx + 1);
        
        // Exclude the current element (backtrack)
        ls.remove(ls.size() - 1);
        subseq(a, ls, idx + 1);
    }
    public static void main(String[] args) {
        // Arr[]={3,2,1}
        // 3 2 1
        //1 
        //2
        //3
        //1 2
        //2 3
        //3 1
 
        // We can do it using the power set
        List<Integer> ls=new ArrayList<>();
        int arr[]={1,2,3};
        subseq(arr,ls,0);

    }
}
