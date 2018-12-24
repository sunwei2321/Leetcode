import org.testng.annotations.Test;

import java.util.Arrays;

public class Problem164_maximum_gap {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] maxVals = new int[nums.length];
        int[] minVals = new int[nums.length];
        Arrays.fill(maxVals, Integer.MIN_VALUE);
        Arrays.fill(minVals, Integer.MAX_VALUE);

        int gap = (int)Math.ceil((double)(max-min)/(double)(nums.length-1));
        for(int num : nums) {
            int i = (num - min)/gap;
            maxVals[i] = Math.max(maxVals[i], num);
            minVals[i] = Math.min(minVals[i], num);
        }

        int result = Integer.MIN_VALUE;
        int prev = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (minVals[i] == Integer.MAX_VALUE) {
                continue;
            }

            result = Math.max(minVals[i] - prev, result);
            prev = maxVals[i];
        }
        return Math.max(result, max - prev);
    }

    @Test
    public void test() {
        System.out.print(new Problem164_maximum_gap().maximumGap(new int[]{3,6,9,1}));
    }
}
