public class Problem42_trapping_rain_water {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        int leftHigh = height[left];
        int rightHigh = height[right];
        while (left < right){
            if (height[left] < height[right]) {
                if (leftHigh > height[left+1]) {
                    result += leftHigh - height[left+1];
                } else {
                    leftHigh = height[left+1];
                }
                left++;
            } else {
                if (rightHigh > height[right-1]) {
                    result += rightHigh - height[right-1];
                } else {
                    rightHigh = height[right-1];
                }
                right--;
            }
        }
        return result;
    }
}
