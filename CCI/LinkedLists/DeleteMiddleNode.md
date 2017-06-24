# Delete Middle Node

Implement an algorithm to delete a node in the middle of a singly linked list
given only access to that node.


# SOL

If we are only given the access to that node, we will have no way to access
the previous node. Therefore, copying the value and set it to the next node
is the only way to go.


```java
public void deleteNode(LinkedListNode n) {
    LinkedListNode temp = n.next;
    if (temp == null) {
        n = null; // if n is the last node, just set it to be null
    } else {
        n.data = temp.data;
        n.next = temp.next;  
    }
}

```
