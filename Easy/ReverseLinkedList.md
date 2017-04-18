# Reverse Linked List

Reverse a singly linked list.

[Link to Leetcode](https://leetcode.com/problems/reverse-linked-list)

[Link to Code](ReverseLinkedList.java)

--------------------------------
## Sol: 

When reversing a singly linked list, we want to make sure that
we don't lose our nodes while we swap two pointers.

In order to achieve that, we will have to create some temporary pointers.

First, creat a `tmp` pointer that points to `head.next`.
Then, create a `tmp2` pointer that initially points to `null`.

And before the iteration, we want to set `head.next = null`.
We have to set `head.next = null` AFTER we set `tmp = head.next`,
else our first node will be gone.

```Java
ListNode tmp = head.next;
ListNode tmp2 = null;
head.next = null;
```

Then inside the while loop,
we want to set `tmp2 = tmp.next`
So the first three nodes that we are looking at will all have a pointer points to itself.
Then we point the second node back to the first by doing `tmp.next = head`.
And reset `head` to be the second node `head = tmp`.
Then finally, move `tmp` to `tmp2`.

```Java
tmp2 = tmp.next;
tmp.next = head;
head = tmp;
tmp = tmp2;
```


  