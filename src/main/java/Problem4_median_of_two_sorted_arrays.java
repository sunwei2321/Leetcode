import java.util.Arrays;

public class Problem4_median_of_two_sorted_arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        if ((l%2) == 0) {
            return (find(nums1, nums2, l/2) + find(nums1, nums2, l/2-1))/2;
        } else {
            return find(nums1, nums2, l/2);
        }
    }

    private double find(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k];
        }
        if (nums2.length == 0) {
            return nums1[k];
        }

        int idx1 = nums1.length/2;
        int idx2 = nums2.length/2;
        int md1 = nums1[idx1];
        int md2= nums2[idx2];

        if (idx1 + idx2 < k) {
            if (md1 > md2) {
                return find(nums1, Arrays.copyOfRange(nums2, idx2+1, nums2.length), k - idx2 - 1);
            } else {
                return find(Arrays.copyOfRange(nums1, idx1+1, nums1.length), nums2, k - idx1 -1);
            }
        } else {
            if (md1 > md2) {
                return find(Arrays.copyOfRange(nums1, 0, idx1), nums2, k);
            } else {
                return find(nums1, Arrays.copyOfRange(nums2, 0, idx2), k);
            }
        }
    }
}
