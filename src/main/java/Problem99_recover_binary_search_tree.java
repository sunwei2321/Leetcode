public class Problem99_recover_binary_search_tree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }

    private void traversal(TreeNode root) {
        if(root.left != null) {
            traversal(root.left);
        }

        if (first == null &&(pre != null && pre.val >= root.val)) {
            first = pre;
        }

        if (first != null && pre.val >= root.val) {
            second = root;
        }

        pre = root;
        if (root.right != null) {
            traversal(root.right);
        }
    }
}
