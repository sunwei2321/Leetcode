import java.util.*;

public class Problem127_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, wordList);
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }

        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            String str = queue.poll();
            int currentDistance = distance.get(str) + 1;
            List<String> words = neighbors(str, dict);
            for (String word : words) {
                if (endWord.equals(word)) {
                    return currentDistance;
                }
                if (!distance.containsKey(word)) {
                    distance.put(word, currentDistance);
                    queue.offer(word);
                }
            }
        }
        return 0;
    }

    private List<String> neighbors(String str, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] tmp = str.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < str.length(); i++) {
                char old = tmp[i];
                tmp[i] = c;
                if (dict.contains(String.valueOf(tmp))) {
                    result.add(String.valueOf(tmp));
                }
                tmp[i] = old;
            }
        }
        return result;
    }
}
