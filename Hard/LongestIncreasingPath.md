#Longest Increasing Path in a Matrix

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

````java
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
````
Return `4`
The longest increasing path is `[1, 2, 6, 9]`.

Example 2:
````Java
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
````
Return `4`
The longest increasing path is `[3, 4, 5, 6]`. Moving diagonally is not allowed.


[Link to Leetcode](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

[Link to Solution](LongestIncreasingPath.java)

-------------------------------------------------------------------

##Solution

The idea is to create a cache matrix that stores the distance


First check if the given matrix is null
````Java
if (matrix == null) {
    return 0;
}      
````

Then, create a cache matrix that has the same size of the given matrix to stroe the distance

`int[][] cache = new int[matrix.length][matrix[0].length];`


Create a variable to store the largest distance.

And use nested for loops to check each value in `matrix` in order to fill in `cache`.

The `helper()` method does all the work - compare each direction to find the increasing path.
Then compare max and the return value from helper() to find the current longest increasing path.
````Java
int max = 0;
for (int i = 0; i < matrix.length; i ++) {
    for (int j = 0; j < matrix[0].length; j ++) {
        int largestDistance = helper(i, j, matrix, cache, Integer.MAX_VALUE);
        max = Math.max(largestDistance, max);
    }
}
````

Don't forget to return `max`

`return max;`


In the `helper()` method, we pass in the current col and row (i and j), `matrix`, `cache` and a max integer.

First if statement is saying if the current col and row is out of bound or if current value in matrix is greater than prev,
then mark 0.

Second if statment shows that if the current col and row in `cache` is greater than 0 which means it's already visited, then retrun it.

Else we will need to recursively check it's up, down, left and right values to see how many are increasing.
````
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
````
