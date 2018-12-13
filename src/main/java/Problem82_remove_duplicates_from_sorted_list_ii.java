public class Problem82_remove_duplicates_from_sorted_list_ii {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = head;
        while(pre.next != null) {
            ListNode current = pre.next;
            while(current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (current != pre.next) {
                pre.next = current.next;
            } else {
                pre = current;
            }
        }
        return sentinel.next;
    }
}
