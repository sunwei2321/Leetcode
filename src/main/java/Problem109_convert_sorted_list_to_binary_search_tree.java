import java.util.List;

public class Problem109_convert_sorted_list_to_binary_search_tree {

    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        current = head;
        return sortedListToBST0(0, size(head) - 1);
    }

    private TreeNode sortedListToBST0(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left)/2;


        TreeNode leftNode = sortedListToBST0(left, mid - 1);

        TreeNode node = new TreeNode(current.val);

        current = current.next;

        TreeNode rightNode = sortedListToBST0(mid + 1, right);

        node.left = leftNode;
        node.right = rightNode;

        return node;
    }

    private int size(ListNode head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
