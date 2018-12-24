public class Problem129_sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root) {
        return visit(root, 0);
    }

    private int visit(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 10 + root.val;

        if (root.left == null && root.right == null) {
            return val;
        } else {
            return visit(root.right, val) + visit(root.left, val);
        }
    }
}
