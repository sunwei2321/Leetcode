import java.util.*;

public class Problem90_subsets_ii {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<Integer> track = new ArrayList<>();
        subsetsWithDup0(nums, 0, result, track);
        return result;
    }

    private void subsetsWithDup0(int[] nums, int index, List<List<Integer>> result, List<Integer> track) {
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            result.add(new ArrayList<>(track));
            subsetsWithDup0(nums, i + 1, result, track);
            track.remove(track.size() - 1);
            visited.add(nums[i]);
        }
    }
}
