# Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
```

begin to intersect at node c1

Notes:

> If the two linked lists have no intersection at all, return null.
> The linked lists must retain their original structure after the function returns.
> You may assume there are no cycles anywhere in the entire linked structure.
> Your code should preferably run in O(n) time and use only O(1) memory.

[Link to Leetcode](https://leetcode.com/problems/intersection-of-two-linked-lists/)

[Link to Code](IntersectionTwoLinkedLists.java)



----------------------------------------

# Sol

The key for this problem is to find the difference in length of these two linked lists.

Assuming we know these two linked lists will intersect, then we know that they will end up with the same tail.


So using two loops to get the number of nodes in each linked lists and find the difference.

In our example above, `listA` has a length of `5` whlie `listB` has a length of `6`.

Then, whoever has the longer list should move forward by `x` steps.
And `x` is calculated by the difference of `lengthA` and `lengthB`.

