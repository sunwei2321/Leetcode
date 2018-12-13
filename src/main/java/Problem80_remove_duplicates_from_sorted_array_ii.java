public class Problem80_remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 1;
        int j = 1;
        int count = 1;
        while(j < nums.length) {
            if (nums[j] != nums[j-1]) {
                nums[i] = nums[j];
                count = 1;
                i++;
            } else if (count < 2) {
                nums[i] = nums[j];
                count++;
                i++;
            }
            j++;
        }
        return i;
    }
}
