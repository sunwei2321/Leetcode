import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem145_binary_tree_postorder_traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode sentinel = new TreeNode(0);
        sentinel.left = root;
        TreeNode current = sentinel;

        while (current != null) {
            if (current.left == null) {
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    print(current.left, prev, result);
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return result;
    }

    private void print(TreeNode head, TreeNode tail, List<Integer> result) {
        reverse(head, tail);
        TreeNode current = tail;
        while(true) {
            result.add(current.val);
            if (current == head) {
                break;
            }
            current = current.right;
        }
        reverse(tail, head);
    }

    private void reverse(TreeNode head, TreeNode tail) {
        if (head == tail) {
            return;
        }
        TreeNode from = head;
        TreeNode to = head.right;
        while(from != tail) {
            TreeNode right = to.right;
            to.right = from;
            from = to;
            to = right;
        }
    }

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        new Problem145_binary_tree_postorder_traversal().postorderTraversal(one);
    }
}
