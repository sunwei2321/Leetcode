public class Problem27_remove_element {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return nums.length;
        }

        int right = nums.length-1;
        int left = 0;
        while(left <= right) {
            if (nums[left] == val) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right --;
            } else {
                left++;
            }
        }
        return right+1;
    }
}
