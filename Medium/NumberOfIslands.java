public int numIslands(char[][] grid) {
    int islands = 0;
    if (grid == null || grid.length == 0) {
        return islands;
    }
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
                searchForIslands(grid, i, j);
                islands++;
            }
        }
    }
    return islands;
}

private void searchForIslands(char[][] grid, int x, int y) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') {
        return;
    }

    // mark the current one
    grid[x][y] = 'x';
    searchForIslands(grid, x + 1, y);
    searchForIslands(grid, x - 1, y);
    searchForIslands(grid, x, y + 1);
    searchForIslands(grid, x, y - 1);
}
