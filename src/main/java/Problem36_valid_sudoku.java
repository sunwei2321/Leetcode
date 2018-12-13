public class Problem36_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        int length = board.length;

        boolean[][] column = new boolean[length][10];
        boolean[][] row = new boolean[length][10];
        boolean[][][] smallboard = new boolean[length/3][length/3][10];

        for (int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int index = c - '0';
                if (row[i][index] || column[j][index] || smallboard[i/3][j/3][index]) {
                    return false;
                }

                row[i][index] = true;
                column[j][index] = true;
                smallboard[i/3][j/3][index] = true;
            }
        }
        return true;
    }
}
