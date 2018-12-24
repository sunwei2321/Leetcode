public class Problem124_binary_tree_maximum_path_sum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath0(root);
        return max;
    }

    private int maxPath0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPath0(root.left));
        int right = Math.max(0, maxPath0(root.right));

        int val = left + right + root.val;

        max = Math.max(max, val);
        return Math.max(left, right) + root.val;
    }
}
