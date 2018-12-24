public class Problem147_insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode(0);
        ListNode current = head;
        ListNode pre;
        ListNode next;
        while(current != null) {
            pre = sentinel;
            next = current.next;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return sentinel.next;
    }
}
