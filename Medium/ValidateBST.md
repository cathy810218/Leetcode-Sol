# Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
```
    2
   / \
  1   3
```
Binary tree `[2,1,3]`, return `true`.


Example 2:
```
    1
   / \
  2   3
```
Binary tree `[1,2,3]`, return `false`.

[Link to Leetcode](https://leetcode.com/problems/validate-binary-search-tree/)

[Link to Code](ValidateBST.java)


--------------------------------------------------

To check if a BST is valid, the only thing we need to check is the `value`.

If `root.val > root.right.val` or `root.val < root.left.val`,
then we know this is not a BST, so we will just retrun `false`.



In order to keep iterating through the tree, we will either use a loop or recustion.


First we want to create a private function that takes in `root` and `min` and `max`.

So if `root.val >= max` or `root.val <= min` then we retrun `false`.

```java
private boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) {
        return true;
    }
    
    if (root.val >= max || root.val <= min) {
        return false;
    }
    
}
```
Lastly, we will have to do the recursive calls for both left and right subtrees and giving min and max value.

For the left subtree, `min` will just be `min` but `max` will be `root.val`
For the right subtree, `max` will just be `max` while `min` will be `root.val`

```
return isValidBST(root.left, min, root.val ) && isValidBST(root.right, root.val, max);
```

And both of these have to return `true` in order to show that this tree is valid BST.



