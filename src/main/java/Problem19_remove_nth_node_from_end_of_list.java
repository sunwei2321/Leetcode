
public class Problem19_remove_nth_node_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode second = sentinel;
        while(n > 0) {
            second = ((ListNode) second).next;
            n--;
        }

        ListNode first = sentinel;
        while(second.next != null) {
            second = second.next;
            first = first.next;
        }

        ListNode result = first.next;
        first.next = result.next;
        return sentinel.next;
    }
}
