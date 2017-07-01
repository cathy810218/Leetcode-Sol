# Stack of Plates

implement a data structure SetOfStacks that is composed of several stacks and
should create a new stack once the previous one exceeds capacity.

# Solutions

```java
class SetOfStacks {
    ArrayList<Stack> stackList;
    int capacity;

    public SetOfStacks(int capacity) {
        this.stackList = new ArrayList<Stack>();
        this.capacity = capacity;
    }

    public void push(int x) {
        Stack lastStack = getStack(stackList.size() - 1);
        if (lastStack is not at capacity) {
            lastStack.push(x);
        } else {
            // create a new one
            Stack s = new Stack(capacity);
            s.push(x);
            stackList.add(s);
        }
    }

    public int pop() {
        Stack last = getStack(stackList.size() - 1);
        int v = last.pop();
        if (last.size == 0) {
            stackList.remove(stackList.size() - 1);
        }
        return v;
    }

    private Stack getStack(int index) {
        return stackList.get(index);
    }

}
```
