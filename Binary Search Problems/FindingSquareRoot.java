public class FindingSquareRoot {
    public static int find(int mid,int n){
        // mid^n
        int ans=1;
        while (n>0) {
            if(n%2==1){
                ans=ans*mid;
                n=n-1;
            }
            else{
                mid=mid*mid;
                n=n/2;
            }
        }
        return ans;
    }

    public static int findingElement(int n,int m){
        int low=1;
        int high=m;
        while (low<=high) {
            int mid=(low+high)/2;
            int Nmid=find(mid,n);
            if(Nmid==m){
                return mid;
            }
            else if(Nmid>m){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
        int n=3;
        int m=27;
        System.out.println(findingElement(n,m));
    }
}