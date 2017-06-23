# Rotate Matrix

Given an image represented by an NxN matrix. Write a method to rotate an image by 90 degree.

# SOL

We need to do transpose first and flip second!

Transpose is making all the rows to cols.
Then flip horizontally.

```java
public void rotate(int[][] matrix, int n) {
	// Transpose
	for (int i = 0; i < n; i ++) {
		for (int j = 0; j < n; j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
	// flip horizontally -> right rotation
	// flip vertically -> left rotation
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n/2; j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[i][n - 1 - j];
			matrix[i][n - 1 - j] = temp;
		}
	}
}

```