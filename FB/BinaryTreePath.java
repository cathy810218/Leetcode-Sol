// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5

// All root-to-leaf paths are:

// ["1->2->5", "1->3"]

public List<String> binaryTreePaths(TreeNode root) {
	List<String> list = new ArrayList<>();
	if (root == null) {
		return list;
	}
	createPaths(root, "", list);
	return list;
}

private void createPaths(String node, String temp, List<String> list) {
	if (node.left == null && node.right == null) {
		// last node
		list.add(temp + node.val);
	}

	if (node.left != null) {
		createPaths(node.left, temp + node.val + "->", list);
	}

	if (node.right != null) {
		createPaths(node.right, temp + node.val + "->", list);
	}
}