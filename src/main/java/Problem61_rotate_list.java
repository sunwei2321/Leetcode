import java.util.ArrayList;
import java.util.List;

public class Problem61_rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode current = head;
        List<ListNode> nodes = new ArrayList();
        while(current.next != null) {
            nodes.add(current);
            current = current.next;
            length++;
        }
        nodes.add(current);
        current.next = head;

        int target = length - k%length;
        current = nodes.get(target-1);

        ListNode next = current.next;
        current.next = null;
        return next;
    }
}
