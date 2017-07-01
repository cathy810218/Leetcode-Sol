# Stack Min

How would you design a stack which in addition to push and pop has a function
min which returns the minimum element?

# Solutions

```java
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int currentMin = minStack.pop();
            if (x < currentMin) {
                minStack.push(currentMin);
                minStack.push(x);
            } else {
                minStack.push(currentMin);
                minStack.push(currentMin);
            }
        }
        stack.push(x);
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }

}

```
