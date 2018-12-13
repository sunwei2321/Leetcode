public class Problem75_sort_colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int current = left;

        while(current <= right) {
            if (nums[current] == 0) {
                if (left == current) {
                    current++;
                    left++;
                } else {
                    nums[current] = nums[left];
                    nums[left] = 0;
                    left++;
                }
            } else if (nums[current] == 1) {
                current++;
            } else {
                nums[current] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }
}
