import java.util.LinkedList;
import java.util.Queue;

public class Problem98_validate_binary_search_tree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        visit(root, queue);

        if (queue.size() == 1) {
            return true;
        }

        int current = queue.poll();
        while(!queue.isEmpty()) {
            if (queue.peek() <= current) {
                return false;
            }
            current = queue.poll();
        }
        return true;
    }

    private void visit(TreeNode root, Queue<Integer> queue) {
        if (root.left != null) {
            visit(root.left, queue);
        }

        queue.offer(root.val);

        if (root.right != null) {
            visit(root.right, queue);
        }
    }
}
