import org.testng.annotations.Test;

public class Problem148_sort_list {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = sortList(mid(head));
        ListNode first = sortList(head);

        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;
        while(first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        while (first != null) {
            current.next = first;
            first = first.next;
            current = current.next;
        }

        while (second != null) {
            current.next = second;
            second = second.next;
            current = current.next;
        }

        return sentinel.next;
    }

    private ListNode mid(ListNode node) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = node;
        ListNode slow = sentinel;
        ListNode fast = sentinel;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    @Test
    public void test() {
        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        ListNode three = new ListNode(3);
        four.next = two;
        two.next = one;
        one.next = three;
        new Problem148_sort_list().sortList(four);
    }
}
