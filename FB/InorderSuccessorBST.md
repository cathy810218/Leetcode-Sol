# 285. Inorder Successor in BST
Given a binary search tree and a node in it,

find the in-order successor of that node in the BST.


Note: If the given node has no in-order successor in the tree, return null.


### Java

```java
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) {
        return null;
    }
    // inorder successor -> the next biggest node
    if (root.val <= p.val) {
        return inorderSuccessor(root.right, p);
    } else {
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}
```


### Objective-C

```objective-c
- (TreeNode *)inorderSuccessor:(TreeNode *)root of:(TreeNode *)p {
    if (root == nil) {
        return nil;
    }

    if ([root.val intValue] < [p.val intValue]) {
        return [self inorderSuccessor:root.right of:p];
    } else {
        TreeNode *node = [self inorderSuccessor:root.left of:p];
        return node == nil ? root : node;
    }
}
```
