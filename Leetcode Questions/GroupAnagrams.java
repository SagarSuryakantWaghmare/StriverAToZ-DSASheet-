import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAngrams(String s[]){
        // We have to use the hashmap to store it
        HashMap<String,List<String>>map=new HashMap<>();
        for(String str:s){
            char[]charArr=str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr=new String(charArr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
     String s[]={"eat","tea","tan","ate","nat","bat"};
    //  We have to find the anagrams

     List<List<String>>ls=groupAngrams(s);
     System.out.println(ls);
    }
}