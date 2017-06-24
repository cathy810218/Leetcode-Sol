# Sum Lists

Sum 2 linked lists

# SOL

```java
public LinkedListNode sumTwoLists(LinkedListNode list1, LinkedListNode list2) {
  if (list1 == null || list2 == null) {
    return list1 == null ?? list2 : list1;
  }
  LinkedListNode nodeA = list1;
  LinkedListNode nodeB = list2;
  LinkedListNode result = new LinkedListNode(0);
  LinkedListNode temp = result;
  int carry = 0;
  while (nodeA != null || nodeB != null || carry > 0) {
    int valueA = nodeA == null ?? 0 : nodeA.data;
    int valueB = nodeB == null ?? 0 : nodeB.data;
    int sum = valueA + valueB + carry;
    carry = sum / 10;
    temp.next = new LinkedListNode(sum % 10);
    temp = temp.next;
    nodeA = nodeA == null ?? null : nodeA.next;
    nodeB = nodeB == null ?? null : nodeB.next;
  }
  return result.next;
}
```
