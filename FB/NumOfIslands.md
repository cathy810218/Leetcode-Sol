# 200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.

You may assume all four edges of the grid are all surrounded by water.

### Java

```java
public int numIslands(char[][] grid) {
	int islands = 0;
	for (int i = 0; i < grid.length; i ++) {
		for (int j = 0; j < grid[0].length; j ++) {
			if (grid[i][j] == '1') {
				// find an island and keep looking
				traverseGrid(grid, i, j);
				islands++;
			}
		}
	}
	return islands;
}

private void traverseGrid(char[][] grid, int x, int y) {
	if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') {
		return;
	}

	// mark the visit unit
	grid[x][y] = 'x';
	traverseGrid(grid, x + 1, y);
	traverseGrid(grid, x, y + 1);
	traverseGrid(grid, x  - 1, y);
	traverseGrid(grid, x, y - 1);
}
```

### Objective-C
```objective-c
- (int)numIslands:(NSArray<NSArray*>*)grid {
    int islands = 0;
    if (grid.count == 0 || grid[0].count == 0) {
        return 0;
    }
    for (int i = 0; i < grid.count; i++) {
        for (int j = 0; j < grid[0].count; j++) {
            if ([grid[i][j] isEqual:@"1"]) {
                // found an island
                [self searchForIslands:[grid mutableCopy] withRow:0 col:0];
                islands++;
            }
        }
    }
    return islands;
}

- (void)searchForIslands:(NSMutableArray<NSMutableArray*> *)grid
				 withRow:(int)x
				     col:(int)y {
    if (x < 0 || y < 0 ||
		x >= grid.count || y >= grid[0].count || ![grid[x][y] isEqual:@"1"]) {
        return;
    }
    grid[x][y] = @"x";
    [self searchForIslands:grid withRow:x+1 col:y];
    [self searchForIslands:grid withRow:x-1 col:y];
    [self searchForIslands:grid withRow:x col:y+1];
    [self searchForIslands:grid withRow:x col:y-1];
}
```
