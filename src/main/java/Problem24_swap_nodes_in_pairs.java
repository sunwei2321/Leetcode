public class Problem24_swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode current = sentinel;

        ListNode l1 = current.next;
        ListNode l2 = l1.next;

        while(l2 != null) {
            current.next = l2;
            ListNode tmp = l2.next;
            l2.next = l1;
            l1.next = tmp;

            current = l1;
            l1 = tmp;
            if (l1 == null) {
                return sentinel.next;
            } else {
                l2 = l1.next;
            }
        }
        return sentinel.next;
    }
}
