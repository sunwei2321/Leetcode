import org.testng.annotations.Test;

import java.util.Arrays;

public class Problem154_find_minimum_in_rotated_sorted_array_ii {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int result = 0;
        if (nums[0] < nums[1]) {
            result = nums[0];
        }

        if (nums[0] > nums[1]) {
            return nums[1];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            return nums[i + 1];
        }
        return result;
    }

    @Test
    public void test() {
        System.out.print(new Problem154_find_minimum_in_rotated_sorted_array_ii().findMin(new int[]{10, 1, 10, 10, 10}));
    }
}
