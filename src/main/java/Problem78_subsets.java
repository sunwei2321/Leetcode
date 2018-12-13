import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        subset0(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subset0(int[] nums, int index, List<Integer> track, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            result.add(new ArrayList(track));
            subset0(nums, i + 1, track, result);
            track.remove(track.size() - 1);
        }
    }
}
