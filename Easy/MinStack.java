class MinStack {
  Stack<Integer> mainStack = new Stack<Integer>();
  Stack<Integer> minStack = new Stack<Integer>();

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

  public void pop() {
    mainStack.pop();
    minStack.pop();
  }

  public int top() {
    return mainStack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}