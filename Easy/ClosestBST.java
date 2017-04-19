public int closestValue(TreeNode root, double target) {
        
    TreeNode nextNode = target < root.val ? root.left : root.right;
    if (nextNode == null) {
        return root.val;
    }
    int temp = closestValue(nextNode, target);
    return Math.abs(root.val - target) < Math.abs(temp - target) ? root.val : temp;
}