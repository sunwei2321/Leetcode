import org.testng.annotations.Test;

import java.util.*;

public class Problem15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> subs = twoSum(nums, i+1, nums[i] * -1);
            for (List<Integer> sub : subs) {
                sub.add(nums[i]);
                result.add(sub);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while(left < right) {
            if (nums[left] + nums[right] == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                left++;
                right--;
                while(left < right && nums[right] == nums[right+1]) {
                    right--;
                }
                while(left < right && nums[left] == nums[left-1]) {
                    left++;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(new Problem15_3sum().threeSum(new int[]{0,0,0,0}));
    }
}