import java.util.*;
public class PalindromePartitioning {
    public static List<List<String>> partition(String s){
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        backTrack(0,s,path,res);
        return res;
    }

    public static void backTrack(int idx,String s,List<String> path,List<List<String>> res){
     if(idx==s.length()){
        res.add(new ArrayList<>(path));
        return;
     }
     for(int i=idx;i<s.length();i++){
        if(isPalindrome(s, idx, i)){
            path.add(s.substring(idx,i+1));
            backTrack(i+1, s, path, res);
            path.remove(path.size()-1);
        }
     }
    }
    public static boolean isPalindrome(String s,int start,int end){
        while (start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aab";
        // ["a","a","b"],["aa","b"]
        int n=s.length()-1;
        List<List<String>>ans=partition(s);
        System.out.println(ans);


    }
}
