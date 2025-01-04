import java.util.*;;
public class TargetBook {

    // public static boolean read(int n,int target,int[]book){
    //     Map<Integer,Integer>mp=new java.util.HashMap<>();
    //     for (int i = 0; i < n; i++) {
    //         int a=book[i];
    //         int more=target-a;
    //         if(mp.containsValue(more)){
    //             return true;
    //         }
    //         mp.put(i, book[i]);
    //     }
    //     return false;

    // }


    // optimal solution

    public static boolean read(int n,int target,int []book){
        int left=0,right=n-1;
        Arrays.sort(book);
        while (left<right) {
          int sum=book[left]+book[right];
          if(sum==target){
            return true;
          }  
          else if(sum<target) left++;
          else right--;
        }
        return false;
    }
    public static void main(String[] args) {
        int n=5;
        
        int target=2;
        int book[]={4,1,2,3,1};
        System.out.println(read(n,target,book));
    }
}
