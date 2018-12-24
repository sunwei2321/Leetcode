import org.testng.annotations.Test;

import java.util.*;

public class Problem131_palindrome_partitioning {
    public List<List<String>> partition(String s) {
        return partition0(s, new HashSet<>(), new HashMap<>());
    }

    private List<List<String>> partition0(String s, Set<String> palidrome, Map<String, List<List<String>>> cache) {
        if (cache.containsKey(s)) {
            return new ArrayList(cache.get(s));
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalidrome(sub, palidrome)) {
                List<List<String>> right = partition0(s.substring(i), palidrome, cache);
                if (!right.isEmpty()) {
                    for (List<String> r : right) {
                        List<String> newVal = new ArrayList<>();
                        newVal.add(s.substring(0, i));
                        newVal.addAll(r);
                        result.add(newVal);
                    }
                }
            }
        }

        if (isPalidrome(s, palidrome)) {
            result.add(Arrays.asList(s));
        }

        if (!result.isEmpty()) {
            cache.put(s, result);
        }

        return result;
    }

    private boolean isPalidrome(String s, Set<String> palidrome) {
        if (palidrome.contains(s)) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        palidrome.add(s);
        return true;
    }

    @Test
    public void test() {
        new Problem131_palindrome_partitioning().partition("bb");
    }
}
