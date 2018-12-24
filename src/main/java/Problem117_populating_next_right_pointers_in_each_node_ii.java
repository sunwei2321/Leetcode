public class Problem117_populating_next_right_pointers_in_each_node_ii {
    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        TreeLinkNode node = root;

        while(node != null) {
            if (node.left != null) {
                node.left.next = node.right == null ? next(node.next) : node.right;
            }

            if (node.right != null) {
                node.right.next = next(node.next);
            }

            node = node.next;
        }

        connect(root.left);
        connect(root.right);
    }

    private TreeLinkNode next(TreeLinkNode root) {

        if (root == null) {
            return null;
        }

        if (root.left != null) {
            return root.left;
        }

        if (root.right != null) {
            return root.right;
        }

        return next(root.next);
    }
}
