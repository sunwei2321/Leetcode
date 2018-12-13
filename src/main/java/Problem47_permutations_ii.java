import java.util.*;

public class Problem47_permutations_ii {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(used, nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(boolean[] used, int[] nums, List<Integer> tracking, List<List<Integer>> result) {
        if (tracking.size() == nums.length) {
            result.add(new ArrayList<>(tracking));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) {
                continue;
            }

            used[i] = true;
            tracking.add(nums[i]);
            dfs(used, nums, tracking, result);
            tracking.remove(tracking.size()-1);
            used[i] = false;
        }
    }
}
