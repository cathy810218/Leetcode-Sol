# Palindrome

Implement a function to check if a linked list is a Palindrome

# SOL

We can reverse first half of the list and check if the value
in each node is equal to the second half of the list.

However, we could also use a Stack to hold on to the values of the
nodes from the first half of the list and then compare them with the second
of the list.

BUT be careful when the list size is odd.

```java
public boolean isPalindrome(LinkedListNode head) {
    LinkedListNode fast = head;
    LinkedListNode slow = head;
    Stack<Integer> stack = new Stack<>();

    while (fast != null && fast.next != null) {
        stack.push(slow.val);
        fast = fast.next.next;
        slow = slow.next;
    }

    // Odd
    if (fast != null) {
        // skip the middle node
        slow = slow.next;
    }

    while (slow != null) {
        if (slow.val != stack.pop()) {
            return false;
        }
        slow = slow.next;
    }
    return true;
}
```
