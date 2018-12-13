import org.testng.annotations.Test;

public class Problem48_rotate_image {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int length = matrix.length;
        for (int i = 0; i <= length/2-1; i++) {
            int distance = length - 2 * i - 1;
            for (int j = 0; j < distance; j++) {
                int topright = matrix[i][i + j];
                int bottomright = matrix[i + j][matrix.length - 1 - i];
                int bottomleft = matrix[matrix.length - 1 - i][matrix.length - 1 - i - j];
                int topleft = matrix[matrix.length - 1 - i - j][i];

                matrix[i][i+j] = topleft;
                matrix[i + j][matrix.length - 1 - i] = topright;
                matrix[matrix.length - 1 - i][matrix.length - 1 - i - j] = bottomright;
                matrix[matrix.length - 1 - i - j][i] = bottomleft;
            }
        }
    }

    @Test
    public void test() {
        int [][] target = new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}};
        new Problem48_rotate_image().rotate(target);
        System.out.println(target);
    }
}
