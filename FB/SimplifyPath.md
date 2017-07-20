# 71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = `"/home/"`, => `"/home"`
path = `"/a/./b/../../c/"`, => `"/c"`


### Java

```java
public String simplifyPath(String path) {
    String[] paths = path.split("/");
    Stack<String> stack = new Stack<>();
    for(String sub : paths) {
        if (sub.equals(".") || sub.equals("")) {
            continue;
        }
        if (sub.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(sub);
        }

    }
    StringBuilder sb = new StringBuilder();
    if (stack.isEmpty()) {
        return "/";
    }

    while (!stack.isEmpty()) {
        sb.insert(0, stack.pop()).insert(0,"/");
    }
    return sb.toString();
}
```
