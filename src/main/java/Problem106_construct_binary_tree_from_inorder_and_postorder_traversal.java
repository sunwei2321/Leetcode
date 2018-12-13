import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Problem106_construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> indexes = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }
        return buildTree0(indexes, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree0(Map<Integer, Integer> indexes, int[] inorder, int inorderLeft, int inorderRight, int[] postorder, int postOrderLeft, int postOrderRight) {
        int inOrderIndex = indexes.get(postorder[postOrderRight]);
        int leftLength = inOrderIndex - inorderLeft;
        int rightLength = inorderRight - inOrderIndex;

        TreeNode node = new TreeNode(postorder[postOrderRight]);
        if (leftLength != 0) {
            node.left = buildTree0(indexes, inorder, inorderLeft, inOrderIndex - 1, postorder, postOrderLeft, postOrderLeft + leftLength - 1);
        }

        if (rightLength != 0) {
            node.right = buildTree0(indexes, inorder, inOrderIndex + 1, inorderRight, postorder, postOrderRight - rightLength, postOrderRight - 1);
        }
        return node;
    }

    @Test
    public void test() {
        new Problem106_construct_binary_tree_from_inorder_and_postorder_traversal().buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }
}
