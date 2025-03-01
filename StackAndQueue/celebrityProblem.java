public class celebrityProblem {
    public static int celebrity(int [][]arr){
        int n=arr.length;
        // Know me ->n-1
        // I Know ->0
        int KnowMe[]=new int[n];
        int IKnow[]=new int[n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                if(arr[i][j]==1){
                   KnowMe[j]++;
                   IKnow[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(KnowMe[i]==n-1&&IKnow[i]==0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
        System.out.println(celebrity(arr));
    }
}