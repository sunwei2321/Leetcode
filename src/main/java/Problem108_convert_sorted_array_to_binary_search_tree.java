public class Problem108_convert_sorted_array_to_binary_search_tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST0(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST0(int[] nums, int left, int right) {
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid > left) {
            node.left = sortedArrayToBST0(nums, left, mid - 1);
        }
        if (right > mid) {
            node.right = sortedArrayToBST0(nums, mid + 1, right);
        }
        return node;
    }
}
