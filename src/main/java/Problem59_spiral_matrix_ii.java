import org.testng.annotations.Test;

public class Problem59_spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return null;
        }

        int[][] matrix = new int[n][n];

        int count = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int loop = (n+1)/2;
        while(loop > 0) {
            int column = left;
            while(column <= right) {
                matrix[top][column++] = count++;
            }

            int row = top + 1;
            while(row <= bottom) {
                matrix[row++][right] = count++;
            }

            if (top < bottom && left < right) {
                column = right - 1;
                while(column >= left) {
                    matrix[bottom][column--] = count++;
                }

                row = bottom - 1;
                while(row >= top+1) {
                    matrix[row--][left] = count++;
                }
            }

            top++;
            bottom--;
            left++;
            right--;
            loop--;
        }
        return matrix;
    }

    @Test
    public void test() {
        new Problem59_spiral_matrix_ii().generateMatrix(3);
    }
}
