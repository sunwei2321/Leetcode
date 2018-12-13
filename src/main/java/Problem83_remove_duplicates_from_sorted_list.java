public class Problem83_remove_duplicates_from_sorted_list {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        while(pre != null) {
            ListNode current = pre.next;
            while(current != null && current.val == pre.val) {
                current = current.next;
            }
            pre.next = current;
            pre = current;
        }
        return head;
    }
}
