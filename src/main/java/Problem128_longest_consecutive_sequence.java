import java.util.HashSet;
import java.util.Set;

public class Problem128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for (int num : nums) {
            vals.add(num);
        }

        int max = 0;
        for (int val : vals) {
            if (!vals.contains(val - 1)) {
                int current = val;
                int count = 1;
                while(vals.contains(current + 1)) {
                    current = current + 1;
                    count++;
                }

                max = Math.max(count, max);
            }
        }
        return max;
    }
}
