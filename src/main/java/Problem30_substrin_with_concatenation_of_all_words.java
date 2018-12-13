import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem30_substrin_with_concatenation_of_all_words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = s.length()/wordLength;

        if (s.length() < wordLength) {
            return result;
        }

        HashMap<String, Integer> dict = new HashMap<>();

        for (String word : words) {
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) + 1);
            } else {
                dict.put(word, 1);
            }
        }
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> findMap = new HashMap<>();
            int findWords = 0;
            int index = i;
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String sub = s.substring(j, j + wordLength);
                if (dict.containsKey(sub)) {
                    if (findMap.containsKey(sub)) {
                        findMap.put(sub, findMap.get(sub) + 1);
                    } else {
                        findMap.put(sub, 1);
                    }

                    if (findMap.get(sub) == dict.get(sub)) {
                        //match
                        findWords++;
                        if (dict.size() == findWords) {
                            //all find
                            result.add(index);
                            String first = s.substring(index, index + wordLength);
                            findMap.put(first, findMap.get(first) - 1);
                            index = index + wordLength;
                            findWords--;
                        }
                    } else if (findMap.get(sub) >= dict.get(sub)){
                        //over
                        while(index < j) {
                            String first = s.substring(index, index + wordLength);
                            int count =  findMap.get(first);
                            index+=wordLength;
                            if (count == dict.get(first)) {
                                findWords--;
                            }
                            findMap.put(first, count - 1);
                            if (first.equals(sub)) {
                                break;
                            }
                        }
                    }
                } else {
                    index = j + wordLength;
                    findMap.clear();
                    findWords = 0;
                }

            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(new Problem30_substrin_with_concatenation_of_all_words().findSubstring("abababab", new String[]{"ab","bc"}));
    }
}
