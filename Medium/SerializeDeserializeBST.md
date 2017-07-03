# SerializeDeserializeBST

Serialization is the process of converting a data structure or object into a sequence of bits so
that it can be stored in a file or memory buffer, or transmitted across a network connection link to
be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary search tree can be serialized to a string and this string can
be deserialized to the original tree structure.

[Link to Leetcode](https://leetcode.com/problems/serialize-and-deserialize-bst/#/description)

[Link to code solutions](SerializeDeserializeBST.java)

# SOL


## Serialize

Serialize a BST using DFS -> Recursion (preorder)

We're required to construct a string, so the best way to do is to use `StringBuilder`.

`sb.append(root.val).append(" ")`

This adds the current root value to the string with a space.

Then we just need to do recursive call starting from left then right.

```java
sb.append(serialize(root.left));
sb.append(serialize(root.right));
```

This is it. Then just return `sb.toString()`


## Deserialize

We need a helper method `dfs()` that takes in an array of strings and index low and high where
`low` is the first index of the array and `high` is the last index of the array.

`TreeNode root = dfs(list, 0, list.length - 1);`

In `dfs()`, create a new node with current value
`TreeNode node = new TreeNode(curr);`


Then
We need to find the value that is greater than the current `root.val` in the array, so that we know
the index at which it's right subtree.

Example:
Given `[10, 5, 3, 7, 20, 25]`

We need to construct a tree like so
```
    10
   /  \
  5   20
 / \    \
3   7   25
```
And at index `4`, the value `20` is greater than `root.val` (which is `10`).
So we find the `divIndex`.

Then `node.left` will be the elements from index `low + 1` to `divIndex - 1`. (`low` is current `node.val`)
And `node.right` will be the elements from index `divIndex` to `strs.length - 1`


The function that helps us to find division index takes in the string array, current root value and both low and high.

Since `low` is the index of current `root`, so we need to increment by `1`.

In the function, initially set the `divIndex` to be `low`.
While `divIndex` is not greater than `high`, we need to search for the value that's greater than `root.val`
Once we find the value, we break out of the loop and return `divIndex`.

NOTE:
What if there are only 2 elements in the string array? `["2", "1"]`
In this case, `low` will equal to `high`.
BUT we will still go through the loop **ONCE** and increment `divIndex` by 1.
