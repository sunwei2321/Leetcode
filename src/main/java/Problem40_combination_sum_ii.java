import org.testng.annotations.Test;

import java.util.*;

public class Problem40_combination_sum_ii {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tracked = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, tracked);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> tracked) {
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            int val = candidates[i];
            if (visited.contains(val)) {
                continue;
            } else {
                visited.add(val);
            }
            if (val == target) {
                List<Integer> find = new ArrayList<>(tracked);
                find.add(target);
                result.add(find);
            } else if (val > target) {
                return;
            } else {
                tracked.add(val);
                dfs(candidates, i + 1, target - val, result, tracked);
                tracked.remove(tracked.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        new Problem40_combination_sum_ii().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
