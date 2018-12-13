import java.util.Stack;

public class Problem85_maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] f = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                f[i][j] = matrix[i][j] - '0';
                if (i > 0 && f[i][j] > 0) {
                    f[i][j] += f[i-1][j];
                }
            }
        }

        int max = 0;
        for (int[] p : f) {
            max = Math.max(max, largestRectangleArea(p));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();

        int max = 0;
        int right = 0;

        while (right < heights.length) {
            int current = heights[right];
            if (stack.isEmpty()||current > heights[stack.peek()]) {
                stack.push(right++);
            } else {
                max = Math.max(max, heights[stack.pop()] * (right - (stack.isEmpty() ? -1 : stack.peek()) -1 ));
            }
        }

        while(!stack.isEmpty()) {
            max = Math.max(max, heights[stack.pop()] * (right - (stack.isEmpty() ? -1 : stack.peek()) -1 ));
        }

        return max;
    }
}
