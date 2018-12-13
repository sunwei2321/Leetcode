import java.util.*;

public class Problem102_binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> track = new LinkedList<>();
        track.offer(root);

        while(!track.isEmpty()) {
            int count = track.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = track.poll();
                list.add(node.val);
                if (node.left != null) {
                    track.offer(node.left);
                }

                if (node.right != null) {
                    track.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
