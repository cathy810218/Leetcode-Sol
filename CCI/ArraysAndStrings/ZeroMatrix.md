# ZeroMatrix

Write an algorithm such that if an element in an MxN matrix is 0,
its entire row and column are set to be 0

# SOL

```java
public void setZeros(int[][] matrix) {
	boolean[] row = new boolean[matrix.length];
	boolean[] col = new boolean[matrix[0].length];

	// Store the row and col index with 0
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[i][j] == 0) {
				row[i] = true;
				col[j] = true;
			}
		}
	}

	// Nullify rows
	for (int i = 0; i < row.length; i++) {
		if (row[i]) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	// Nullify cols
	for (int i = 0; i < col.length; i ++) {
		if (col[i]) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][i] = 0;
			}
		}
	}
}

```
