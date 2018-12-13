import org.testng.annotations.Test;

public class Problem41_first_missing_positive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length;) {
            int val = nums[i];
            if (val > 0 && val < nums.length && nums[val-1] != val) {
                int tmp = nums[val-1];
                nums[val-1] = val;
                nums[i] = tmp;
            } else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val != i+1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    @Test
    public void test() {
        new Problem41_first_missing_positive().firstMissingPositive(new int[]{-1,4,2,1,9,10});
    }
}
