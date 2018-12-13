import java.util.ArrayList;
import java.util.List;

public class Problem52_n_queens_ii {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        dfs(board, 0, result);
        return result.size();
    }

    private void dfs(boolean[][] board, int current, List<List<String>> result) {
        for(int i = 0; i < board.length; i++) {
            if (isValid(board, current, i)) {
                board[current][i] = true;
                if (current != board.length-1) {
                    dfs(board, current+1, result);
                } else {
                    List<String> p = new ArrayList<>();
                    for (int m = 0; m < board.length; m++) {
                        StringBuilder line = new StringBuilder();
                        for (int n = 0; n < board.length; n++) {
                            if (board[m][n]) {
                                line.append("Q");
                            } else {
                                line.append(".");
                            }
                        }
                        p.add(line.toString());
                    }
                    result.add(p);
                }
                board[current][i] = false;
            }
        }
    }

    private boolean isValid(boolean[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column]){
                return false;
            }
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j <= board.length-1; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
