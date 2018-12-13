public class Problem86_partition_list {
    public ListNode partition(ListNode head, int x) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode sentinelAfter = new ListNode(0);

        ListNode pre = sentinel;
        ListNode current = sentinel.next;
        ListNode after = sentinelAfter;
        while(current != null) {
            if (current.val >= x) {
                pre.next = current.next;
                current.next = null;
                after.next = current;
                after = after.next;
                current = pre.next;
            } else {
                pre = current;
                current = current.next;
            }
        }

        pre.next = sentinelAfter.next;
        return sentinel.next;
    }
}
