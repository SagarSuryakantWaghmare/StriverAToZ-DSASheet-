import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderStored {
    public static ArrayList<ArrayList<String>> findSequence(String startWord, String targetWord, String[] wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }
        st.add(startWord); // Ensure startWord is in the set
        if (!st.contains(targetWord)) return new ArrayList<>(); // If targetWord is not reachable

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.remove();

            if (vec.size() > level) {
                level++;
                for (String s : usedOnLevel) {
                    st.remove(s);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord)) {
                        ArrayList<String> newPath = new ArrayList<>(vec);
                        newPath.add(replacedWord);
                        q.add(newPath);
                        usedOnLevel.add(replacedWord);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String startWord = "def";
        String targetWord = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        ArrayList<ArrayList<String>> ans = findSequence(startWord, targetWord, wordList);
        System.out.println("Sequence: " + ans);
    }
}
