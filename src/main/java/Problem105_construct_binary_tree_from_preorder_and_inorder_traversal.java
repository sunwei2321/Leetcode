import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Problem105_construct_binary_tree_from_preorder_and_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> indexes = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }
        return buildTree0(indexes, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree0(Map<Integer, Integer> indexs, int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        int inOrderIndex = indexs.get(preorder[preLeft]);
        int lenghtLeft = inOrderIndex - inLeft;
        int lengthRgiht = inRight - (inOrderIndex);
        TreeNode node = new TreeNode(preorder[preLeft]);
        if (lenghtLeft != 0) {
            node.left = buildTree0(indexs, preorder, preLeft + 1 , preLeft + lenghtLeft, inorder, inLeft, inLeft + lenghtLeft - 1);
        }
        if (lengthRgiht != 0) {
            node.right = buildTree0(indexs, preorder, preLeft + lenghtLeft + 1, preRight, inorder, inOrderIndex + 1, inRight);
        }
        return node;
    }

    @Test
    public void test() {
        new Problem105_construct_binary_tree_from_preorder_and_inorder_traversal().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
