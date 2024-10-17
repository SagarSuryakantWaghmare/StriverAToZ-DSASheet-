import java.util.*;;
public class MajorityElement2 {
    // public static List major(int[]arr,int n){
        // O(n^2)
    //  List<Integer> l=new ArrayList<>(); 
    //  for(int i=0;i<n-1;i++){
    //     if(l.size()==0||l.get(0)!=arr[i]){
    //         int count=0;
    //         for(int j=0;j<n-1;j++){
    //             if(arr[j]==arr[i]){
    //                 count++;
    //             }
    //         }
    //         if(count>n/3){
    //             l.add(arr[i]);
    //         }
    //     }
    //     if(l.size()==2) break;
    //  }

    public static List<Integer> majorityElement(int[] arr, int n) {
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        // Step 1: Find potential majority elements
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && el2 != arr[i]) {
                count1 = 1;
                el1 = arr[i];
            } else if (count2 == 0 && el1 != arr[i]) {
                count2 = 1;
                el2 = arr[i];
            } else if (arr[i] == el1) {
                count1++;
            } else if (arr[i] == el2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify if the found elements are majority
        List<Integer> l = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (el1 == arr[i]) count1++;
            if (el2 == arr[i]) count2++;
        }

        int mini = n / 3;
        if (count1 > mini) l.add(el1);
        if (count2 > mini) l.add(el2);

        return l;
    }

    public static void main(String[] args) {
        int arr[]={1,1,1,3,3,2,2,2};
        int n=8;
        // 8/3
        // Since 1 and 2 are two ans

        // 
        List ans=majorityElement(arr,n);
        System.out.println(ans);

    }
}
