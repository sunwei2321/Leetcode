public class Problem114_flatten_binary_tree_to_linked_list {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten0(root);
    }

    private TreeNode flatten0(TreeNode node) {
        TreeNode last = node;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null) {
            node.right = left;
            node.left = null;
            last = flatten0(left);
        }

        if (right != null) {
            last.right = right;
            last.left = null;
            last = flatten0(right);
        }
        return last;
    }
}
