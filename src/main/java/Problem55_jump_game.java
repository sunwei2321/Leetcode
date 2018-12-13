public class Problem55_jump_game {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int currentEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > currentEnd) {
                return false;
            }
            currentEnd = Math.max(currentEnd, i + nums[i]);
            if (currentEnd >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
