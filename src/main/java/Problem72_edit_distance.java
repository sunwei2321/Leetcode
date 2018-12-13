public class Problem72_edit_distance {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int l1 = word1.length();
        int l2 = word2.length();
        int[][] matrix = new int[l1+1][l2+1];

        matrix[0][0] = 0;
        for (int i = 1; i <= l1; i++) {
            matrix[i][0] = matrix[i-1][0] + 1;
        }

        for (int i = 1; i <= l2; i++) {
            matrix[0][i] = matrix[0][i-1] + 1;
        }

        for (int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                }
            }
        }

        return matrix[l1][l2];
    }
}
