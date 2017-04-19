# Closest Binary Search Tree

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.



[Link to Leetcode](https://leetcode.com/problems/closest-binary-search-tree-value/)

[Link to Code](ClosestBST.java)



--------------------------------------

# Sol

Given you the target value, you need to find the node that has the closest value to target.

Since `target` is a float, not int, you won't really want to check if `root.val` == `target`.

So first thing, we want to know if the current `root.val` is `>` or `<` our `target`.


If `target < root.val`, then we want to check the left subtree, else rigjt subtree.

Therefore,

`TreeNode nextNode = target < root.val ? root.left : root.right;`

but if there are no children, we know that the closest value should just be `root.val`.


```java
if (nextNode == null) {
	return root.val;
}
```

Here comes to the recursion part.


If there are 10 other nodes on the left subtree, then we will have to keep checking each node's value.
So we will pass in the current `nextNode` again, and assign it to a `temp` variable.

`int temp = closestValue(nextNode, target);`

So every time when we do recursive call, we will get a new `temp`.


Then finally, we want to check if the difference between this `temp` and `target` is smaller
than `root.val` and `target`.


`return Math.abs(root.val - target) < Math.abs(temp - target) ? root.val : temp;`









