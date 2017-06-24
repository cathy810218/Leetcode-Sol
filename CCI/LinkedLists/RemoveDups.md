# Remove Dups

Write code to remove duplicates from an unsorted linked list.

Note: How would you solve this problem if a temp buffer is not allowed?

# Sol

Use a Set

```java
public void removeDups(LinkedListNode n) {
  Set<Integer> set = new HashSet<>();
  LinkedListNode temp = n;
  LinkedListNode prev = null;
  while (temp != null) {
    if (set.contains(temp.data)) {
      prev.next = n.next; // remove node
    } else {
      set.add(temp.data);
      prev = n;
    }
    temp = temp.next;
  }
}

```


Without extra buffer -> 2 points O(N^2)

```java
public void removeDups(LinkedListNode n) {
  LinkedListNode curr = n;

  while (current != null) {
    LinkedListNode runner = n;
    while (runner.next != null) {
      if (current.data == runner.next.data) {
        runner.next = runner.next.next;
      } else {
        runner = runner.next;  
      }
    }
    current = current.next;
  }
}
```
