import java.util.Arrays;

public class Problem16_3sum_closest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == target) {
                    return target;
                }
                int diff = sum - target;
                if (diff > 0) {
                    right--;
                    if (diff < minDiff) {
                        minDiff = diff;
                        result = sum;
                    }
                } else {
                    left++;
                    if (diff * -1 < minDiff) {
                        minDiff = diff * -1;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
