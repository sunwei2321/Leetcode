public class Problem37_sudoku_solver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        solveSudoku0(board);
    }

    private boolean solveSudoku0(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if  (solveSudoku0(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }

            if (board[i][column] == c) {
                return false;
            }

            if (board[(row/3)*3 + i/3][(column/3)*3 + i%3] == c) {
                return false;
            }
        }
        return true;
    }
}
