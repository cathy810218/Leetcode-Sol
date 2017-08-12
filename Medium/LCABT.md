# Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

````
     _______3______
    /              \
 ___5__          ___1__
/      \        /      \
6       2       0       8
       /  \
       7   4
````

For example, the lowest common ancestor (LCA) of nodes `5` and `1` is `3`. Another example is LCA of nodes `5` and `4` is `5`, since a node can be a descendant of itself according to the LCA definition.



[Link to Leetcode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree)

[Link to Code](LCABT.java)

--------------------------------------

# Sol
So the idea is that when we start looking down from the root node, if both left and right contain the given targets node, then for sure the current root is their LCA!

If only one side has value, for example, if `left` is `null`, return `right` because target both node must be at right subtree if left is `null`.


Use recursion and the base case is that when the passed in node is `null`, we will just return that node.

````java
if (root == null || root == p || root == q) {
    return root;
}
````

And later in the function, we can use this to check if it's `null`.

````java
if (left == null) {
    return right;
} else if (right == null) {
    return left;
} else {
    // both have value
    return root;
}
````
