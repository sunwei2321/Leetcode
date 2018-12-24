public class Problem136_single_number {
    public int singleNumber(int[] nums) {
        int base = nums[0];
        for (int i = 1; i < nums.length; i++) {
            base ^= nums[i];
        }
        return base;
    }
}
