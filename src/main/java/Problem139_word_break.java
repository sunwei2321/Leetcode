import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem139_word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet();
        for (String word : wordDict) {
            dict.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        System.out.println(new Problem139_word_break().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
