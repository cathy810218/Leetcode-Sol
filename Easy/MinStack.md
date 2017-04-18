# Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

[Link to Leetcode](https://leetcode.com/problems/min-stack/)

[Link to Code](MinStack.java)

--------------------------------------

# Sol

In order to keep track of the min value, we will need to create two stacks.

One is the main stack that behaves just like a regular stack.

One keeps track of the min value in the stack.


These two stacks "must" have the same size.

The important part of this implementation is `push(x)` method.


First, if there's nothing in `minStack`, we need to `push(x)`.

Then if the current value `x` is smaller than the last value `minStack.peek()`,
we also need to `push(x)`.

If the current value `x` is greater than the last value `minStack.peek()`,
instead of pushing `x`, we push the last value in `minStack` again.

**This is very important as if the min value gets popped, we will still have the most
current min value in the min stack.**

```java
 public void push(int x) {
    if (minStack.isEmpty()) {
        minStack.push(x);
    } else if (minStack.peek() > x) {
        minStack.push(x);
    } else {
        minStack.push(minStack.peek());
    }
    mainStack.push(x);
  }
```