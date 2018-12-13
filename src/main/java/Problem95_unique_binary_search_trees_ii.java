import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem95_unique_binary_search_trees_ii {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.EMPTY_LIST;
        } else {
            return generateTrees0(1, n);
        }
    }

    private List<TreeNode> generateTrees0(int start, int end) {
        if (start == end) {
            return Arrays.asList(new TreeNode(start));
        } else {
            List<TreeNode> result = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                List<TreeNode> left;
                List<TreeNode> right;
                if (start == i) {
                    left = new ArrayList<>();
                    left.add(null);
                } else {
                    left = generateTrees0(start, i-1);
                }

                if (end == i) {
                    right = new ArrayList<>();
                    right.add(null);
                } else {
                    right = generateTrees0(i+1, end);
                }

                for(TreeNode nodeLeft : left) {
                    for(TreeNode nodeRight : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = nodeLeft;
                        node.right = nodeRight;
                        result.add(node);
                    }
                }
            }
            return result;
        }
    }
}
