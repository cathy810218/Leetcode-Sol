# 102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,
```
    3
   / \
  9  20
    /  \
   15   7
```
return its level order traversal as:
```
[
  [3],
  [9,20],
  [15,7]
]
```

### Java

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int currLevelNodes = 0;
    while (!queue.isEmpty()) {
        List<Integer> levelSublist = new ArrayList<Integer>();
        currLevelNodes = queue.size();

        for (int i = 0; i < currLevelNodes; i++) {
            TreeNode currNode = queue.remove();
            levelSublist.add(currNode.val);

            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        result.add(levelSublist);
    }
    return result;
}
