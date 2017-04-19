public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
        return null;
    }
    TreeNode root = helper(nums, 0, nums.length - 1);
    return root;   
}

private TreeNode helper(int nums[], int low, int high) {
    if (low > high) {
        return null;
    }
    
    int mid = (high + low) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(nums, low, mid - 1);
    node.right = helper(nums, mid + 1, high);
    return node;
}