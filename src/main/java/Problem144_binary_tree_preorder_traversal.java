import java.util.ArrayList;
import java.util.List;

public class Problem144_binary_tree_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    result.add(current.val);
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return result;
    }
}
