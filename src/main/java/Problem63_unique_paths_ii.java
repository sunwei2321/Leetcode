public class Problem63_unique_paths_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] matrix = new int[m][n];

        matrix[0][0] = (obstacleGrid[0][0] == 0 ? 1 :0);

        for (int i = 1; i < m; i++) {
            matrix[i][0] = (obstacleGrid[i][0] == 0 ? matrix[i-1][0] : 0);
        }

        for (int i = 1; i < n; i++) {
            matrix[0][i] = (obstacleGrid[0][i] == 0 ? matrix[0][i-1] : 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = (obstacleGrid[i][j] == 0 ? matrix[i-1][j] + matrix[i][j-1] : 0);
            }
        }
        return matrix[m-1][n-1];
    }
}
