import java.util.ArrayList;
import java.util.List;

public class Problem113_path_sum_ii {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            pathSum0(root, sum, result, new ArrayList<>());
            return result;
        }
    }

    private void pathSum0(TreeNode root, int sum, List<List<Integer>> result, List<Integer> track) {
        if (root == null) {
            return;
        }

        track.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(track));
        }

        pathSum0(root.left, sum - root.val, result, track);
        pathSum0(root.right, sum - root.val, result, track);

        track.remove(track.size() - 1);
    }
}
