# Return Kth To Last

Implement an algorithm to find the kth to last element of a singly linked list.

# SOL

If we know the length of the linked list, we can just iterate through the list
and find (length - k)th element.

But assuming we don't know the length of linked list...

We can use two pointers that are k nodes apart.
And going through the list until one hits end of the list.
Then we know that another pointer is pointing to the kth to the last.

```java
public LinkedListNode kthToLastNode(LinkedListNode head, int k) {
    if (head == null) {
        return null;
    }
    LinkedListNode p1 = head;
    LinkedListNode p2 = head;
    int steps = k;
    while (steps > 0) {
        if (p2 == null) {
            return null;
        }
        p2 = p2.next;
        steps --;
    }

    while (p2 != null) {
        p1 = p1.next;
        p2 = p2.next;
    }
    return = p1;
}

```
