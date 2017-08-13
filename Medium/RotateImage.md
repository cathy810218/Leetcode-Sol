# Rotate Image
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

[Link to Leetcode](https://leetcode.com/problems/rotate-image/)

[Link to code solutions](RotateImage.java)
-------------------------

## SOL

Rotating an image by 90 degrees without creating another matrix to hold the pixels (i.e do it in place), we normally will use two steps.

1. Transpose
2. Flip

Transpose means switch rows with columns.
Flip left with right for clockwise, but if we want to do it counter clockwise, we can flip top and bottom.

So first - Transpose
````java
for (int i = 0; i < matrix.length; i++) {
    for (int j = i; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
````

NOTE: In the inner for loop, we start our counter `j` from `i` because if we do `0` instead of `i`, then we will be switching back.

For example, when `i = 0`, and `j = 1`, we swap them, and when `i = 1` but `j` also starts from `0` then we are swapping them back to it's original position.

Second - Flip left right

````java
for (int i = 0; i < matrix.length; i ++) {
    for (int j = 0; j < matrix[0].length / 2; j++) {
        int temp = matrix[i][matrix[0].length - j - 1];
        matrix[i][matrix[0].length - j - 1] = matrix[i][j];
        matrix[i][j] = temp;
    }
}
````

Remember to do `-1` to avoid index out of bounds exception.
