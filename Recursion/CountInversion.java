public class CountInversion{
    // Brute force approch
    public static int count(int[]a){
        int n=a.length;
        int count=0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i]<a[j]){
                    // System.out.println(a[i]+" "+a[j]);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[]agrs){
        int arr[]={5,3,2,4,1};
        // we have to find the inversion
        // i< j and a[i]>a[j]
        System.out.println(count(arr));
        
        
    }
}