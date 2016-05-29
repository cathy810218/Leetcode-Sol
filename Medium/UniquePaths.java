public class Solution {
    public int uniquePaths(int m, int n) {
        // create a cache matrix to store the possible paths
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++ ) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 1; // if its at the edge, there's only one path
                } else {
                    cache[i][j] = cache[i][j-1] + cache[i-1][j];
                }
            }
        }
        return cache[m-1][n-1]; // the bottom right corner
    }
}
