import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.EMPTY_LIST;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        List<Integer> result = new ArrayList<>();
        while(top <= bottom && left <=right) {
            int column = left;
            while(column <= right) {
                result.add(matrix[top][column]);
                column++;
            }
            int row = top + 1;
            while(row <= bottom) {
                result.add(matrix[row][right]);
                row++;
            }

            if (top < bottom && left < right) {
                column = right - 1;
                while(column >= left) {
                    result.add(matrix[bottom][column]);
                    column--;
                }
                row = bottom - 1;
                while(row >= top + 1) {
                    result.add(matrix[row][left]);
                    row--;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
