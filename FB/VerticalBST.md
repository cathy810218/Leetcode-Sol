# 314. Binary Tree Vertical Order Traversal
Given a binary tree, return the vertical order traversal of its nodes' values.
If two nodes are in the same row and column, the order should be from left to right.

### Java

```java
public List<List<Integer>> verticalBST(TreeNode root) {
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	if (root == null) {
		return results;
	}
	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	Queue<TreeNode> nodeQ = new LinkedList<>();
	Queue<Integer> colQ = new LinkedList<>();

	int min = 0;
	int max = 0;

	// root is 0 vertical
	nodeQ.add(root);
	colQ.add(0);

	while(!nodeQ.isEmpty()) {
		TreeNode currNode = nodeQ.remove();
		Integer currCol = colQ.remove();

		if (!map.containsKey(currCol)) {
			map.put(currCol, new ArrayList<Integer>());
		}
		map.get(currCol).add(currNode.val);

		if (currNode.left != null) {
			nodeQ.add(currNode.left);
			colQ.add(currCol - 1);
			min = Math.min(min, currCol - 1);
		}

		if (currNode.right != null) {
			nodeQ.add(currNode.right);
			colQ.add(currCol + 1);
			max = Math.max(max, currCol + 1);
		}
	}

	for (int i = min; i <= max; i ++) {
		results.add(map.get(i))
	}

	return results;
}
```

### Objective-C

```objective-c
- (NSArray<NSArray<NSNumber*> *>*)verticalBST:(TreeNode *)root {
    NSMutableArray<NSArray *> *result = [[NSMutableArray alloc] init];
    if (root == nil) {
        return result;
    }

    // create 2 queses -> FIFO, so use append and remove first
    NSMutableArray<TreeNode *> *nodeQueue = [[NSMutableArray alloc] init];
    NSMutableArray<NSNumber *> *colQueue = [[NSMutableArray alloc] init];

    NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
    int min = 0;
    int max = 0;
    // add the root to queue
    [nodeQueue addObject:root];
    [colQueue addObject:@0];

    while (nodeQueue.count > 0) {
        TreeNode *currNode = [nodeQueue objectAtIndex:0];
        NSNumber *currCol = [colQueue objectAtIndex:0];
        [nodeQueue removeObjectAtIndex:0];
        [colQueue removeObjectAtIndex:0];

        if (dict[currCol] == nil) {
            NSMutableArray *arr = [[NSMutableArray alloc] init];
            dict[currCol] = arr;
        }
        NSMutableArray *arr = dict[currCol];
        [arr addObject:currNode];

        if (currNode.left != nil) {
            [nodeQueue addObject:currNode.left];
            [colQueue addObject:[NSNumber numberWithInt:([currCol intValue] - 1)]];
            min = MIN(min, [currCol intValue] - 1);
        }

        if (currNode.right != nil) {
            [nodeQueue addObject:currNode.right];
            [colQueue addObject:[NSNumber numberWithInt:([currCol intValue] + 1)]];
            max = MAX(max, [currCol intValue] + 1);
        }
    }

    for (int i = min; i <= max; i ++) {
        NSArray *arr = dict[[NSNumber numberWithInt:i]];
        [result addObject:arr];
    }

    return [result copy];
}
```
