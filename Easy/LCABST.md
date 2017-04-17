# Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

```
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
```
For example, the lowest common ancestor (LCA) of nodes `2` and `8` is `6`. 
Another example is LCA of nodes `2` and `4` is `2`, since a node can be a descendant of itself according to the LCA definition.

[Link to Leetcode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

[Link to Code](LCABST.java)


--------------------------------------

# Sol

Check the given nodes' values and compare them with the root value.

1. If `root` value is smaller than both `p` and `q`, then we check the right subtree.

2. If 'root' value is greater than both `p` and `q`, then we check the left subtree.

3. Else, we just return `root`


Because LCA has to be either one of the two numbers or in between.