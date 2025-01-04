import java.util.ArrayList;
import java.util.List;

public class alterateNumbers {
    public static int[] alternate(int[]arr){
     int n=arr.length;
     List<Integer> pos=new ArrayList<>();
     List<Integer> neg=new ArrayList<>();
     for (int i = 0; i < n; i++) {
        if(arr[i]>0){
          pos.add(arr[i]);
        }
        else{
            neg.add(arr[i]);
        }
     }
     if(pos.size()>neg.size()){
       for (int i = 0; i < neg.size(); i++) {
        arr[2*i]=pos.get(i);
        arr[2*i+1]=neg.get(i);
       }
       int index=neg.size()*2;
       for (int i = neg.size(); i < pos.size(); i++) {
        arr[index]=pos.get(i);
        index++;
       }
     }
     else{
        for (int i = 0; i < pos.size(); i++) {
            arr[2*i]=pos.get(i);
            arr[2*i+1]=neg.get(i);
           }
           int index=pos.size()*2;
           for (int i = pos.size(); i < neg.size(); i++) {
            arr[index]=neg.get(i);
            index++;
           }

     }
     return arr;
    }
    public static void main(String[] args) {
        int arr[]={-1,-2,-4,3,6};
        int ans[]=alternate(arr);
        for (int i : ans) {
            System.out.print(i+" ");
        } 

    }
}
