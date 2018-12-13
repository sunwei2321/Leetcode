import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem46_permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        List<List<Integer>> result = new ArrayList<>();
        result.add(tmp);

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> vals : result) {
                    List<Integer> f = new ArrayList<>(vals);
                    f.add(j, nums[i]);
                    newResult.add(f);
                }
            }
            result = newResult;
        }
        return result;
    }
}
