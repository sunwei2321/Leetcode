public class Problem152_maximum_product_subarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], Math.min(min[i-1] * nums[i], max[i-1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i-1] * nums[i], max[i-1] * nums[i]));
        }

        int maxValue = max[0];
        for (int i = 1; i < nums.length; i++) {
            maxValue = Math.max(maxValue, max[i]);
        }

        return maxValue;
    }
}
