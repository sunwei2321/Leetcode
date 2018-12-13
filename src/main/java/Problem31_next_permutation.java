import org.testng.annotations.Test;

import java.util.Arrays;

public class Problem31_next_permutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int head = 0;
        for (int i = nums.length - 1; i > 0;) {
            if (nums[i-1] >= nums[i]) {
                i--;
            } else {
                head = i;
                break;
            }
        }
        if (head != 0) {
            int target = head;
            for (int i = head; i < nums.length; i++) {
                if (nums[i] > nums[head - 1] && nums[i] < nums[target]) {
                    target = i;
                }
            }

            int tmp = nums[head - 1];
            nums[head - 1] = nums[target];
            nums[target] = tmp;
        }
        Arrays.sort(nums, head, nums.length);
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,3,2};
        new Problem31_next_permutation().nextPermutation(nums);
        System.out.println(nums.toString());
    }
}
