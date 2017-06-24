# Partition

Write code to partition a linked list around a value x, such that all nodes
less than x come before all nodes greater than or equal to x.


# SOL

```java
public LinkedListNode partition(LinkedListNode node, int x) {
    LinkedListNode front = node;
    LinkedListNode end = node;

    while (node != null) {
        LinkedListNode temp = node.next;
        if (node.data < x) {
            // put it in the front
            node.next = front;
            front = node;
        } else {
            // put it last
            end.next = node;
            end = node;
        }
        node = temp;
    }
    // remove last
    end.next = null;
    return front;
}
```
