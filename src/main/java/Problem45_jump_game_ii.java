public class Problem45_jump_game_ii {
    public int jump(int[] nums) {
        int currentEnd = 0;
        int nextEnd = 0;
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            nextEnd = Math.max(nextEnd, nums[i] + i);
            if (nextEnd >= nums.length-1) {
                return count + 1;
            }
            if (currentEnd == i) {
                currentEnd = nextEnd;
                count++;
            }
        }
        return count;
    }
}
