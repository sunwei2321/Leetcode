public class Problem26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
