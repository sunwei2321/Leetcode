import java.util.HashMap;
import java.util.Map;

public class Problem138_copy_list_with_random_pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<Integer, RandomListNode> copied = new HashMap<>();
        copy0(head, copied);
        return copied.get(head.label);
    }

    private void copy0(RandomListNode node, Map<Integer, RandomListNode> copied) {
        RandomListNode newNode = new RandomListNode(node.label);
        copied.put(newNode.label, newNode);
        if (node.next != null) {
            if (!copied.containsKey(node.next.label)) {
                copy0(node.next, copied);
            }
            newNode.next = copied.get(node.next.label);
        }

        if (node.random != null) {
            if (!copied.containsKey(node.random.label)) {
                copy0(node.random, copied);
            }
            newNode.random = copied.get(node.random.label);
        }
    }
}
