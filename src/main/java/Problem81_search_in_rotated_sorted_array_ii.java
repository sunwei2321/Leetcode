import org.testng.annotations.Test;

public class Problem81_search_in_rotated_sorted_array_ii {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[left]) {
                if (nums[mid] >= target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] < nums[left]) {
                if (target >= nums[left] || target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    @Test
    public void test() {
        new Problem81_search_in_rotated_sorted_array_ii().search(new int[]{1, 3, 5}, 1);
    }
}
