import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Problem76_minimum_window_substring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dict = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c: chars) {
            if (!dict.containsKey(c)) {
                dict.put(c, 1);
            } else {
                dict.put(c, dict.get(c) + 1);
            }
        }

        int left = 0;
        int right = -1;
        int wordCount = 0;

        int[] result = {-1, 0, 0};

        Map<Character, Integer> find = new HashMap<>();
        while(true) {
            if (wordCount == dict.size()) {
                char head = s.charAt(left);
                if (find.containsKey(head)) {
                    int count = find.get(head);
                    if (count == dict.get(head)) {
                        wordCount--;
                    }
                    find.put(head, count - 1);
                }
                left++;
            } else {
                right++;
                if (right == s.length()) {
                    break;
                }
                char tail = s.charAt(right);
                if (!dict.containsKey(tail)) {
                    continue;
                }
                if (!find.containsKey(tail)) {
                    find.put(tail, 1);
                } else {
                    find.put(tail, find.get(tail) + 1);
                }

                if (find.get(tail).intValue() == dict.get(tail).intValue()) {
                    wordCount++;
                }
            }

            if (wordCount == dict.size()) {
                if (result[2] == 0 || (result[2] >  right-left + 1)) {
                    result[0] = left;
                    result[1] = right;
                    result[2] = right-left + 1;
                }
            }
        }
        if (result[2] == 0) {
            return "";
        }
        return s.substring(result[0], result[1] + 1);
    }

    @Test
    public void test() {
        new Problem76_minimum_window_substring().minWindow("A", "AA");
    }
}
