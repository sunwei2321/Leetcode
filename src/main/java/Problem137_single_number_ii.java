public class Problem137_single_number_ii {
    public int singleNumber(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int i = 0; i < nums.length; i++) {
            x2 ^= x1 & nums[i];
            x1 ^= nums[i];
            mask = ~(x2 & x1);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}
