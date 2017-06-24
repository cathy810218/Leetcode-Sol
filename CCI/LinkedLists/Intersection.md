# Intersection

Given two linked lists, determine if the two lists intersect.
Return intersecting node.

# SOL

```java
public LinkedListNode intersection(LinkedListNode listA, LinkedListNode listB) {
  if (listA == null || listB == null) {
    return null;
  }
  // go through both list to get their lengths
  LinkedListNode tempA = listA;
  LinkedListNode tempB = listB;
  int countA = 0;
  int countB = 0;
  while (tempA != null) {
    countA++;
    tempA = tempA.next;
  }

  while (tempB != null) {
    countB++;
    tempB = tempB.next;
  }
  if (tempA != tempB) {
    //different tail node
    return null;
  }
  //reset pointers
  tempA = listA;
  tempB = listB;
  int diff = Math.abs(countA - countB);
  if (countA > countB) {
    while(diff > 0) {
      tempA = tempA.next;
      diff--;
    }
  } else {
    while(diff > 0) {
      tempB = tempB.next;
      diff--;
    }
  }

  while (tempA != null) {
    if (tempA == tempB) {
      return tempA;
    }
    tempA = tempA.next;
    tempB = tempB.next;
  }
  return null;
}
```
