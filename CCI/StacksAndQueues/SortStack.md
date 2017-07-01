# Sort Stack

Write a program to sort a stack such that the smallest items are on the top.

# Solutions

```java
public Stack<Integer> sortStack(Stack<Integer> s) {
    Stack<Integer> resultStack = new Stack<>();

    while (!s.isEmpty()) {
        int sVal = s.pop();
        while (!resultStack.isEmpty() && resultStack.peek() > sVal) {
            s.push(resultStack.pop());
        }
        resultStack.push(sVal);
    }
    return resultStack;
}
```
