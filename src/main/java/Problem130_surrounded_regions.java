import java.util.HashSet;
import java.util.Set;

public class Problem130_surrounded_regions {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }

        Set<Integer> circle = new HashSet<>();
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            search(r, c, i, 0, circle, board);
            search(r, c, i, c - 1, circle, board);
        }

        for (int i = 0; i < c; i++) {
            search(r, c, 0, i, circle, board);
            search(r, c, r - 1, i , circle, board);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((board[i][j] == 'O') && !circle.contains(index(r, c, i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void search(int r, int c, int row, int column, Set<Integer> circle, char[][] board) {
        int index = index(r, c, row, column);
        if (circle.contains(index)) {
            return;
        }

        if (board[row][column] == 'O') {
            circle.add(index);
            if (row > 0) {
                search(r, c, row - 1, column, circle, board);
            }
            if (row < r - 1) {
                search(r, c, row + 1, column, circle, board);
            }
            if (column > 0) {
                search(r, c, row, column - 1, circle, board);
            }
            if (column < c - 1) {
                search(r, c, row, column + 1, circle, board);
            }
        }
    }

    private int index(int r, int c, int row, int column) {
        return row * c + column;
    }
}
