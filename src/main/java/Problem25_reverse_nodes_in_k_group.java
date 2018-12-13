import org.testng.annotations.Test;

public class Problem25_reverse_nodes_in_k_group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode pre = sentinel;

        int count = 0;
        while (head != null) {
            count ++;
            if (count%k == 0) {
                pre = reverseK(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return sentinel.next;
    }

    private ListNode reverseK(ListNode pre, ListNode next) {
        ListNode head = pre.next;
        ListNode current = head.next;
        while(current != next) {
            head.next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = head.next;
        }
        return head;
    }


    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode r = new Problem25_reverse_nodes_in_k_group().reverseKGroup(n1, 3);
        System.out.println(r.val);
    }
}
