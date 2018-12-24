import java.util.LinkedList;
import java.util.Queue;

public class Problem116_populating_next_right_pointers_in_each_node {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        connect0(queue);
    }

    private void connect0(Queue<TreeLinkNode> queue) {
        while (!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                TreeLinkNode node = queue.poll();
                if (i == count - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
}
