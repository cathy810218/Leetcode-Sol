// 314. Binary Tree Vertical Order Traversal
// Given a binary tree, return the vertical order traversal of its nodes' values. 
// If two nodes are in the same row and column, the order should be from left to right.
public List<List<Integer>> verticalBST(TreeNode root) {
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	if (root == null) {
		return results;
	}
	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	Queue<TreeNode> nodeQ = new LinkedList<>();
	Queue<Integer> colQ = new LinkedList<>();

	int min = 0;
	int max = 0;

	// root is 0 vertical
	nodeQ.add(root);
	colQ.add(0);

	while(!nodeQ.isEmpty()) {
		TreeNode currNode = nodeQ.remove();
		Integer currCol = colQ.remove();

		if (!map.containsKey(currCol)) {
			map.put(currCol, new ArrayList<Integer>());
		}
		map.get(currCol).add(currNode.val);

		if (currNode.left != null) {
			nodeQ.add(currNode.left);
			colQ.add(currCol - 1);
			min = Math.min(min, col - 1);
		}

		if (currNode.right != null) {
			nodeQ.add(currNode.right);
			colQ.add(currCol + 1);
			max = Math.max(max, col + 1);
		}
	}
	
	for (int i = min; i < max; i ++) {
		results.add(map.get(i))
	}

	return results;
}