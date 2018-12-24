public class Problem115_distinct_subsequences {
    public int numDistinct(String s, String t) {
        int[][] matrix = new int[t.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            matrix[0][i] = 1;
        }

        for(int i = 0; i < t.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(i)) {
                    matrix[i+1][j+1] = matrix[i+1][j] + matrix[i][j];
                } else {
                    matrix[i+1][j+1] = matrix[i+1][j];
                }
            }
        }
        return matrix[t.length()][s.length()];
    }
}
