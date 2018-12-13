public class Problem79_word_search {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist0(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist0(char[][] board, String word, int index, int m, int n) {
        if (m == board.length || m < 0) {
            return false;
        }
        if (n == board[0].length || n < 0) {
            return false;
        }

        if (word.charAt(index) != board[m][n]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        board[m][n] ^= 256;
        boolean exist = exist0(board, word, index + 1, m + 1, n) ||
                exist0(board, word, index + 1, m, n + 1) ||
                exist0(board, word, index + 1, m - 1, n) ||
                exist0(board, word, index + 1, m, n - 1);
        board[m][n] ^= 256;
        return exist;
    }
}
