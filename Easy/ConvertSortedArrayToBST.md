# Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


[Link to Leetcode](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

[Link to Code](ConvertSortedArrayToBST.java)



--------------------------------------

# Sol

So when talking about BST, we know there's something to do with O(log N).

Talking about O(Log N), we know there's gotta be doing something using 1/2 of the time.

Now given a sorted array, we want to make a BST.



The first thing that comes up to our mind should be "finding the middle value".

The mid value in a sorted array will be the `root` of this BST.


For example:

`[1, 2, 3, 4, 5, 6, 7]`

The middle value should be `4` which is our `root.val`.

then everything before `4` should be in the left subtree, and after `4` should be in right subtree.

So now looking at `[1, 2, 3]`, we will just need to get the mid value again to construct the node.

And using the equation `int midIndex = (lowIndex + high) / 2` gives us the answer of index `1` which is the value `2`.

So each step is pretty much the same, we only need to pass in different "low index and high index" (range).



In order to do that, we create a `helper` method

```java
private TreeNode helper(int nums[], int low, int high) {
   
}
```


So initially we will just pass in 

`TreeNode root = helper(nums, 0, nums.length - 1);`
to get the first mid value which is our `root`.

Then in the helper method, we make some recursive calls for both left and right trees.

```java
if (low > high) {
    return null;
}

int mid = (high + low) / 2;
TreeNode node = new TreeNode(nums[mid]);
node.left = helper(nums, low, mid - 1);
node.right = helper(nums, mid + 1, high);
return node;
```

Since we're creating a tree, in the `helper` method, we want to create a new node with the mid index in the `nums`.

Right subtree keeps the same `high` index, and left subtree keeps the same `low` index.
The only index that gets updated is the `mid` index.




