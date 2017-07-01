# Queue via Stacks

Implement a MyQueue class which implements a queue using two stacks.

# Solutions

```java
class MyQueue {
    Stack<Integer> stackNew;
    Stack<Integer> stackOld;

    public MyQueue() {
        this.stackNew = new Stack<>();
        this.stackOld = new Stack<>();
    }

    public void push(int x) {
        stackOld.push(x);
    }

    public int pop() {
        if (stackNew.isEmpty()) {
            // move all stacks from old to new
            while (!stackOld.isEmpty()) {
                stackNew.push(stackOld.pop());
            }
        }
        return stackNew.pop();
    }

    public int peek() {
        if (stackNew.isEmpty()) {
            // move all stacks from old to new
            while (!stackOld.isEmpty()) {
                stackNew.push(stackOld.pop());
            }
        }
        return stackNew.peek();
    }

    public int size() {
        return stackNew.size() + stackOld.size();
    }
}
```
