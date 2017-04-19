# Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.


[Link to Leetcode](https://leetcode.com/problems/merge-two-sorted-lists/)

[Link to Code](MergeTwoSortedLists.java)



--------------------------------------


# Sol

First, create a result `ListNode`.
We need to decide where the first node of `result` should point to.

So we need to check to see who has the smallest the value between `l1.val` and `l2.val`.

```java
ListNode result = null;
if (l1.val < l2.val) {
    result = l1;
    l1 = l1.next;
} else {
    result = l2;
    l2 = l2.next;
}
```

Then once we have our `result` points to the first node,
we will need to create a `temp` node to run through the linked list.

`ListNode temp = result;`

Finally, in the `while` loop, 
we also do the same thing: Check if `l1.val` and `l2.val` who is smaller,
then assign `temp.next` to be the node that has the smaller value.


```java
while (l1 != null && l2 != null) {
    if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
    } else {
        temp.next = l2;
        l2 = l2.next;
    }
    temp = temp.next;
}
```

Last, but no the least...

Your `l1` and `l2` don't always have the same length, so we will have to check
if `l1` or `l2` still has nodes.

We will jsut add the rest of the nodes in our `result` by doing this:
`temp.next = l1 == null ? l2 : l1;`



Then just return `result`


