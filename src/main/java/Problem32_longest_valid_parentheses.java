import java.util.Stack;

public class Problem32_longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        int[] p = new int[s.length()+1];
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ')') {
                int prev = i - 1 - p[i];
                if (prev >=0 && s.charAt(prev) == '(') {
                    p[i+1] = p[i] + p[prev] + 2;
                }
            }
            max = Math.max(max, p[i+1]);
        }
        return max;
    }
}
