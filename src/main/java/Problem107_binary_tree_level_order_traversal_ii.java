import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem107_binary_tree_level_order_traversal_ii {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> track= new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode c = queue.poll();
                track.add(c.val);
                if (c.left != null) {
                    queue.offer(c.left);
                }

                if (c.right != null) {
                    queue.offer(c.right);
                }
            }
            result.add(0, track);
        }
        return result;
    }
}
