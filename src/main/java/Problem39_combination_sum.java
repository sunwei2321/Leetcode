import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39_combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tracked = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, tracked);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> tracked) {
        for (int i = index; i < candidates.length; i++) {
            if (target == candidates[i]) {
                List<Integer> find = new ArrayList<>(tracked);
                find.add(candidates[i]);
                result.add(find);
            } else if (candidates[i] > target) {
                return;
            } else {
                tracked.add(candidates[i]);
                dfs(candidates, i, target - candidates[i], result, tracked);
                tracked.remove(tracked.size() - 1);
            }
        }
    }
}
