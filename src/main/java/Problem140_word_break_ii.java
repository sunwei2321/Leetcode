import java.util.*;

public class Problem140_word_break_ii {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        return wordBreak0(s, dict, new HashMap<>());
    }

    private List<String> wordBreak0(String s, Set<String> dict, Map<String, List<String>> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (s.isEmpty()) {
            return Arrays.asList("");
        }

        List<String> result = new ArrayList<>();
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> subs = wordBreak0(s.substring(word.length()), dict, cache);
                for (String sub : subs) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        cache.put(s, result);
        return result;
    }
}
