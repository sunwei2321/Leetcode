public class Problem132_palindrome_partitioning_ii {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) &&(j+1 >= i-1 || palindrome[j+1][i-1])) {
                    palindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(dp[j-1] + 1, min);
                }
            }

            dp[i] = min;
        }
        return dp[s.length() - 1];
    }
}
