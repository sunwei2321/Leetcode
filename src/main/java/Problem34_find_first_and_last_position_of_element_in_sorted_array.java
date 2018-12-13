public class Problem34_find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        int[] result = null;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result == null) {
                    result = new int[]{i, i};
                } else {
                    result[0] = Math.min(result[0], i);
                    result[1] = Math.max(result[1], i);
                }

            }
        }
        return result == null ? new int[]{-1, -1} : result;
    }
}
