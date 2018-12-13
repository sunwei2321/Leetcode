public class Problem21_merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode m = l1;
        ListNode n = l2;
        while(m != null && n != null) {
            if (m.val >= n.val) {
                current.next = new ListNode(n.val);
                n = n.next;
            } else {
                current.next = new ListNode(m.val);
                m = m.next;
            }
            current = current.next;
        }

        while (m != null) {
            current.next = new ListNode(m.val);
            m = m.next;
            current = current.next;
        }
        while (n != null) {
            current.next = new ListNode(n.val);
            n = n.next;
            current = current.next;
        }
        return head.next;
    }
}
