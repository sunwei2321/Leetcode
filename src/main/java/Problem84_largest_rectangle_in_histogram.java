import java.util.Stack;

public class Problem84_largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
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
