public class Problem92_reverse_linked_list_ii {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int diff = n - m;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        head = sentinel.next;
        ListNode pre = sentinel;
        while(m > 1) {
            head = head.next;
            pre = pre.next;
            m--;
        }

        ListNode next = head.next;
        while(diff > 0) {
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = head.next;
            diff--;
        }
        return sentinel.next;
    }
}
