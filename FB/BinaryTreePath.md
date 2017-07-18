# 257. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:
```
    1
  /   \
 2     3
  \
   5
```
All root-to-leaf paths are:

`["1->2->5", "1->3"]`

### Java
```java
public List<String> binaryTreePaths(TreeNode root) {
	List<String> list = new ArrayList<>();
	if (root == null) {
		return list;
	}
	createPaths(root, "", list);
	return list;
}

private void createPaths(String node, String temp, List<String> list) {
	if (node.left == null && node.right == null) {
		// last node
		list.add(temp + node.val);
	}

	if (node.left != null) {
		createPaths(node.left, temp + node.val + "->", list);
	}

	if (node.right != null) {
		createPaths(node.right, temp + node.val + "->", list);
	}
}
```

### Objective-C

```objective-c
- (NSArray<NSString *>*)binaryTreePaths:(TreeNode *)root {
    NSMutableArray<NSString *> *result = [[NSMutableArray alloc] init];
    [self createPaths:root resultArray:result string:@""];
    return result;
}

- (void)createPaths:(TreeNode *)node resultArray:(NSMutableArray *)result string:(NSString*)str {
    // the last one does not need ->
    if (node.left == nil && node.right == nil) {
        [result addObject:[NSString stringWithFormat:@"%@%@",str, node.val]];
    }

    if (node.left != nil) {
        NSString *tmp = [NSString stringWithFormat:@"%@%@->",str,node.val];
        [self createPaths:node.left resultArray:result string:tmp];
    }

    if (node.right != nil) {
        NSString *tmp = [NSString stringWithFormat:@"%@%@->",str,node.val];
        [self createPaths:node.right resultArray:result string:tmp];
    }
}
```
