import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderOne {
    public static class Pair {
        String node;
        int length;
        Pair(String node, int length) {
            this.node = node;
            this.length = length;
        }
    }

    public static int wordLadder(String[] words, String startWord, String targetWord) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        HashSet<String> st = new HashSet<>();
        for (String word : words) {
            st.add(word);
        }
        st.remove(startWord);

        while (!q.isEmpty()) {
            String node = q.peek().node;
            int steps = q.peek().length;
            q.remove();

            if (node.equals(targetWord)) {
                return steps;
            }

            for (int i = 0; i < node.length(); i++) {
                char[] replacedCharArray = node.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] words = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der";
        String targetWord = "dfs";
        System.out.println("Shortest path to get from startWord to targetWord: " + wordLadder(words, startWord, targetWord));
    }
}
