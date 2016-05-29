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
If there are `2` ways to get to (1,1) and 
