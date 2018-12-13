public class Problem2_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean extra = false;
        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode head = new ListNode(0);
        ListNode current = head;
        while(head1 != null || head2 != null) {
            int sum = extra ? 1:0;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }

            current.next = new ListNode(sum%10);
            current = current.next;
            extra = (sum >= 10);
        }
        if (extra) {
            current.next = new ListNode(1);
        }
        return head.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
