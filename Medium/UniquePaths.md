#Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

[Link to Leetcode](https://leetcode.com/problems/unique-paths/)

[Link to Solution](UniquePaths.java)

----------------------------------------------

## Solutions

Lets start out from a smaller grid: 2 by 2.
````
1 *
* *
````
The initial (0,0) is always one, and going to left and right are also `1` since there's only one way to get to (0,1) and (1,0).
**Notice: We can only move down and right. We are not allowed to move up and left.**
````
1 1
1 *
````
Getting to (1,1) we can go "left -> down" or "down -> left". Hence, there are two ways to get to (1,1)
````
1 1
1 2
````

Apply the same analogy to a 2 by 3 grid.

````
1 1 *
1 2 *
````
There's only one way to go to (2,0)
````
1 1 1
1 2 *
````
If there are `2` ways to get to (1,1) and `1` way to get to (2,0).
Then getting to (2,1) is just the sum of `2` + `1` = `3`
````
1 1 1
1 2 3
````

Try the size of 3 by 7 grid.
````
1 1 1 * * * *
1 2 3 * * * *
* * * * * * *
````

From the previous two examples, we know if it's the first row and column, then there's only `1` way to get there.
Hence, (0,x) and (x,0) are all 1's. (Note: First column and row stars at 0 index)
````
1 1 1 1 1 1 1 
1 2 3 * * * *
1 * * * * * *
````

Same as the previous examples,
if we are looking at (3,1), we just need to add up the values at (2,1) and (3,0) which gives us `4`.
Keep summing up the previous values then you will get this:
````
1 1 1  1  1  1  1
1 2 3  4  5  6  7
1 3 6 10 15 21 28
````

Then the last row and column gives us `28` the total of the unique ways to get to the bottom right corner.

------------------------------------------

## Steps

1. Create a cache matrix that has the size of m by n
      `int[][] cache = new int[m][n];`
2. Nested for loops: if column is 0 or row is 0, then set the value to 1. 
(only one unique way to get to (0,x) and (x,0))

      ````java
      if (i == 0 || j == 0) {
          cache[i][j] = 1; 
      }
      ````
3. If neither `i` nor `j` is `0`, then we just need to add up the current position's top and left possible paths.

      ````java
      else {
        cache[i][j] = cache[i][j-1] + cache[i-1][j];
      }
      ````
4. Return the value at bottom right corner
    `return cache[m-1][n-1];`

