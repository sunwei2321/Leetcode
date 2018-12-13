import java.util.Arrays;

public class Problem3_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int start = 0;
        Arrays.fill(chars, -1);
        for(int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] >= start) {
                start = chars[s.charAt(i)] + 1;
            }
            chars[s.charAt(i)] = i;
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}
