#Verify Preorder Serialization of a Binary Tree

One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

````
     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
````

For example, the above binary tree can be serialized to the string `"9,3,4,#,#,1,#,#,2,#,6,#,#"`, where `#` represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character `'#'` representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as `"1,,3"`.

[Link to Leetcode](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/)

[Link to code solutions](PreorderBT.java)

-------------------------------------

##Solutions

If we have **_N_** leaf nodes, then we know that we have **_N-1_** non-leaf nodes in order to make a valid Binary Tree.
Therefore, checking if a tree is valid BT, we will have to keep track of the difference between non-leaf and leaf nodes.

Use `split()` to get rid of commas in the given string.
And in the for loop, we check each character in this given string.
Initially the difference is 0, but if we see a leaf node (ie. `#`), then increase the difference by 1, else subtract by 1.

````Java
        int diff = 0;
        for (String currChar : preorder.split(",")) {
            if (diff == 1) { return false; } 
            diff = currChar.equals("#") ? diff+1 : diff-1;
        }
````

If it's a valid BT, the end value of `diff` will be 1.
Adding a `if` statement in the for loop is to check if the diff hits 1, but its not end of the tree, then its invalid.

For example:

1. The given string is `"#123"`. Intuitively, if the first node is `#`, then it does not have any children.

2. The given string is `"12###32##"`, so if you calculate it, the difference of leaf and non-leaf node is 1. 
You would assume that this is a valid BT. However, It retruns `false` because the third `#` makes the `diff = 1`.
(`"12###"`) but we have not yet hit the end of the string.
Therefore, we want to return `false` immediately.

