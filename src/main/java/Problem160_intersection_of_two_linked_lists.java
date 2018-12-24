
public class Problem160_intersection_of_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = length(headA);
        int lengthB = length(headB);

        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = lengthB - lengthA;
            while(diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode head) {
        int count = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
