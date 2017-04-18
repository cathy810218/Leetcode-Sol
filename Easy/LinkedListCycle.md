# Linked List Cycle


Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

[Link to Leetcode](https://leetcode.com/problems/linked-list-cycle/)

[Link to Code](LinkedListCycle.java)


--------------------------------------


# Sol

A cycle in a linked list means that there's a "loop".

In order to check if there's a loop, we will need two pointers.

(From cracking the coding interviews)

We will use the runner techniques.

So first we create two pointers.

```java
ListNode runner = head.next;
ListNode walker = head;
```

We know that runner moves two steps at a time while walker moves one step. 

If there's a loop (cycle), runner and walker will eventually meet.
(If A runs twice as fast as B, they will meet when B finishs two circles and A finishs one)

```java
while (runner != walker) {
    if (runner == null || runner.next == null) {
        return false;
    }
    runner = runner.next.next;
    walker = walker.next;
}
return true;
```

