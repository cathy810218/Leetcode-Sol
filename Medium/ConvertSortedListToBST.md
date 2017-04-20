# Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


[Link to Leetcode](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

[Link to Code](ConvertSortedListToBST.java)



-------------------------------------------------------


# Sol

This is pretty similar to [Convert Sorted Array to BST](Easy/ConvertSortedArrayToBST.md)

But instead of an array, we are converting a list.

When constructing a BST, we know that we need to get the middle value first to create its root.

In the array, we can just use the ( first index + last index ) / 2 to get the middle index.


However, in Linked List, we don't have indices.
So here, we have to use 2 pointers.

One calls runner (because it goes 2 steps at a time) and one calls walker (1 step at a time).

When the `runner` reaches the end (`null`) of the list, we know that `walker` should be pointing to the middle node.


There are two cases - even number of nodes and odd number of nodes.

So in our loop, we will have to check if `runner != end && runner.next != end`.



First, we need to create a `helper` method which takes in `head` and `tail` because left and right sub-trees have 
different `tail`.


In the helper method,
we first check if 

```java
if (head == tail) { return null; }
```

Then create `runner` and `walker` pointers both point to `head`.
And write a `loop` to move them until we reach the end.

```java
while (runner != tail && runner.next != tail) {
    runner = runner.next.next;
    walker = walker.next;
}
```

At this point, we know that `walker` is pointing to the middle node,
we will use it for our `root`.

`TreeNode root = new TreeNode(walker.val);`

Then next thing is to do the same thing but pass in different `head` and `tail` 
for the recusive calls.

```java
root.left = helper(head, walker);
root.right = helper(walker.next, tail);
```





