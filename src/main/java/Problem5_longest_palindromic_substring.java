import org.testng.annotations.Test;

public class Problem5_longest_palindromic_substring {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            p[i][i] = true;
            if (i < length - 1) {
                p[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            }
        }

        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                p[i][j] = p[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }

        String maxSub = "";
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (p[i][j]) {
                    if ((j-i+1) > max) {
                        max = j-i+1;
                        maxSub = s.substring(i, j+1);
                    }
                }
            }
        }
        return maxSub;
    }

    @Test
    public void test() {
        new Problem5_longest_palindromic_substring().longestPalindrome("cbbd");
    }
}
