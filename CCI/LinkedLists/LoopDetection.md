# Loop Detection

Given a circular linked list, implement an algorithm that returns the node
at the beginning of the loop.

# SOL

```java
public LinkedListNode findBeginningNode(LinkedListNode head) {
    if (head == null || head.next == null) {
        return null;
    }
    // they have to both start at head to get the current merging node
    LinkedListNode runner = head;
    LinkedListNode walker = head;

    while (runner != null && runner.next != null) {
        runner = runner.next.next;
        walker = walker.next;
        if (runner == walker) {
            break;
        }
    }

    if (runner == null || runner.next == null) {
        // no loop
        return null;
    }

    // Otherwise, move walker back to head and move one step at a time till they meet
    walker = head;
    while (runner != walker) {
        walker = walker.next;
        runner = runner.next.next;
    }
    return walker;
}
```
