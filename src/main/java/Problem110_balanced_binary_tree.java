public class Problem110_balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if (isBalanced0(root) < 0) {
            return false;
        } else {
            return true;
        }
    }

    private int isBalanced0(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = isBalanced0(node.left);
        int right = isBalanced0(node.right);

        if (left < 0 || right < 0) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
