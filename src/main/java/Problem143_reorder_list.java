import org.testng.annotations.Test;

public class Problem143_reorder_list {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        ListNode first = head;
        while(first.next != mid) {
            first = first.next;
        }
        first.next = null;
        first = head;

        ListNode second = new ListNode(1);
        second.next = null;
        ListNode current = mid;
        ListNode next;
        while(current != null) {
            next = current.next;
            current.next = second.next;
            second.next = current;
            current = next;
        }
        second = second.next;

        ListNode currentNode = new ListNode(0);
        while(first != null && second != null) {
            currentNode.next = first;
            first = first.next;
            currentNode = currentNode.next;
            currentNode.next = second;
            currentNode = currentNode.next;
            second = second.next;
        }
        currentNode.next = second;
    }

    @Test
    public void test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        new Problem143_reorder_list().reorderList(one);
    }
}
