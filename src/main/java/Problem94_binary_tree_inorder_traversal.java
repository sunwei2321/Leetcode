import java.util.*;

public class Problem94_binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Queue<Integer> queue = new LinkedList();
        inorderTraversal0(root, queue);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    private void inorderTraversal0(TreeNode root, Queue<Integer> queue) {
        if (root.left != null) {
            inorderTraversal0(root.left, queue);
        }
        queue.offer(root.val);
        if (root.right != null) {
            inorderTraversal0(root.right, queue);
        }
    }
}
