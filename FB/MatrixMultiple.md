# 311. Sparse Matrix Multiplication
Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number

### Java
```java
public int[][] multiply(int[][] A, int[][] B) {
	int rowA = A.length;
	int colArowB = A[0].length;
	int colB = B[0].length;
	int[][] results = new int[rowA][colB];

	for (int i = 0; i < rowA; i ++) {
		for (int j = 0; j < colArowB; j ++) {
			if (A[i][j] != 0) {
				for (int k = 0; k < colB; k ++) {
					if (B[j][k] != 0) {
						results[i][k] += A[i][j] * B[j][k];
					}
				}
			}
		}
	}
	return result;
}
```

### Objective-C

```objective-c
- (NSArray<NSArray *>*)multiply:(NSArray<NSArray *>*)A  with:(NSArray<NSArray *>*)B {
    int rowA = (int)A.count;
    int colArowB = (int)B.count;
    int colB = (int)B[0].count;
	// pad result 2d array with 0s
    NSMutableArray<NSMutableArray<NSNumber *>*> *result = [[NSMutableArray alloc] initWithArray:b];
    for (int i = 0; i < rowA; i++) {
        [result addObject: [[NSMutableArray alloc] init]];
        for (int j = 0; j < colB; j++) {
            [result[i] addObject:@0];
        }

    }

    for (int i = 0; i < rowA; i ++) {
        for (int j = 0; j < colArowB; j++) {
            if (![A[i][j] isEqual:@0]) {
                for (int k = 0; k < colB; k++) {
                    if (![B[j][k] isEqual: @0]) {
                        int t = [A[i][j] intValue] * [B[j][k] intValue];
                        int resultInt = [result[i][k] intValue] + t;
                        result[i][k] = [NSNumber numberWithInt:resultInt];
                    }
                }
            }
        }
    }
    return [result copy];
}
```
