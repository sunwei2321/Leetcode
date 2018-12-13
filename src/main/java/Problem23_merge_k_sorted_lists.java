import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23_merge_k_sorted_lists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.offer(node);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while(!queue.isEmpty()) {
            ListNode top = queue.poll();
            current.next = new ListNode(top.val);
            current = current.next;
            if (top.next != null) {
                queue.offer(top.next);
            }
        }
        return head.next;
    }
}
