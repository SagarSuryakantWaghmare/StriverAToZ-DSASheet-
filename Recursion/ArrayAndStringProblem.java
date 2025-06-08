public class ArrayAndStringProblem {
    public static void print(int[]a){
        for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+" ");
        }
    }
    public static void swap(int a[],int l,int r){
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }
    public static void rev(int[]arr,int l,int r){
        if(l>r){
            return;
        }
        swap(arr, l, r);
        rev(arr, l+1, r-1);

    }
    public static boolean isPalindrome(String s,int a1,int a2){
       if(s.charAt(a1)!=s.charAt(a2)){
        return false;
       }
       if(a1>a2){
        return true;
       }
       isPalindrome(s, a1+1, a2-1);
       return true;
    }
    public static void main(String[] args) {
        // Reversing array 
        // int []arr={1,2,3,4,5};
        // print(arr);
        // rev(arr,0,arr.length-1);
        // System.out.println();
        // print(arr);


        //Check a string is palindrome or not
        String s="saas";
        System.out.println(isPalindrome(s,0,s.length()-1));
        

    }
}
