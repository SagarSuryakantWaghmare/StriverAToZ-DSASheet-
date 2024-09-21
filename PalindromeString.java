public class PalindromeString {
    public static boolean isPalindrome(String s){
      String cleanString=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();  
      int left=0;
      int right=cleanString.length()-1;
      while (left<right) {
        if(cleanString.charAt(left)!=cleanString.charAt(right)){
            return false;
        }
        left++;
        right--;
      }
      return true;
    }
   public static void main(String[] args) {
    String s="A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));
   } 
}
