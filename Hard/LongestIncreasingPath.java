public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        // create a cache matrix to stroe the distance
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                int largestDistance = helper(i, j, matrix, cache, Integer.MAX_VALUE);
                max = Math.max(largestDistance, max);
            }
        }
        return max;
    }
    
    private int helper(int i, int j, int[][] matrix, int[][] cache, int prev) {
        if ( i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= prev) {
            return 0;
        }
        
        if (cache[i][j] > 0) { // calculated already
            return cache[i][j];
        } else {
            int curr = matrix[i][j];
            int temp = 0;
            temp = Math.max(helper(i - 1, j, matrix, cache, curr), temp);
            temp = Math.max(helper(i + 1, j, matrix, cache, curr), temp);
            temp = Math.max(helper(i , j + 1, matrix, cache, curr), temp);
            temp = Math.max(helper(i , j - 1, matrix, cache, curr), temp);
            cache[i][j] = ++temp;
            return temp;
        }
        
    }
}
