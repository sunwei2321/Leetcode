public class Problem74_search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int row = mid / n;
            int column = mid % n;
            if (matrix[row][column] == target) {
                return true;
            }

            if (matrix[row][column] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
