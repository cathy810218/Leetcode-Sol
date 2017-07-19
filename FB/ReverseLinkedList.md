# 206. Reverse Linked List

Reverse a singly linked list.

### Java

```java
public ListNode reverseList(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode node = head.next;
    ListNode temp = null;
    head.next = null;
    while (node != null) {
        temp = node.next;
        node.next = head;
        head = node;
        node = temp;
    }
    return head;
}
```


### Objective-C

```objective-c
- (ListNode *)reverseList:(ListNode *)head {
    if (head == nil) {
        return nil;
    }

    ListNode *node = head.next;
    ListNode *temp = nil;
    head.next = nil;
    while (node != nil) {
        temp = node.next;
        node.next = head;
        head = node;
        node = temp;
    }
}
```
