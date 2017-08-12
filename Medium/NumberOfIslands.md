# Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
````
11110
11010
11000
00000
````
Answer: 1

Example 2:
````
11000
11000
00100
00011
````
Answer: 3


[Link to Leetcode](https://leetcode.com/problems/number-of-islands/)

[Link to Code](NumberOfIslands.java)


--------------------------------------------------

# SOL

When we iterate through the matrix and see a start of an island like `1`, we need to go deep down to look for it's _top_, _left_, _right_, _bottom_ and check if these are also `1`.
So I use recursion to go through the matrix to see if there's an island.

Important!! Remember to mark the "node" that we visited.

So in the first function, we use two for loops to check current value.
````java
int islands = 0;
for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
            // look for it's neighbors
            searchForIslands(grid, i, j);
            islands ++;
        }
    }
}
````

Then in the second function, we are given `i` and `j` which indicates the current row and col (i.e current position).

So if `x` and `y` is not within the grid's bounds, return immediately.
No need to go down more. Also, if the current value is not `1` that means we are not on the island anymore, we need to return.

````java
private void searchForIslands(char[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != `1`) {
        return;
    }

    // Remember to mark the current One
    grid[x][y] = 'x';

    // now we can go through left, right, top, bottom recursively
    searchForIslands(grid, x + 1, y);
    searchForIslands(grid, x, y + 1);
    searchForIslands(grid, x - 1, y);
    searchForIslands(grid, x, y - 1);
}
````
