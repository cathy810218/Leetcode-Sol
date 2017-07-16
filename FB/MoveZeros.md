# 283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining
the relative order of the non-zero elements.

For example, given `nums = [0, 1, 0, 3, 12]`, after calling your function,
nums should be `[1, 3, 12, 0, 0]`.

### Java
```java
public void moveZeros(int[] nums) {
		int front = 0;
		for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
						// move to front
						int temp = nums[i];
						nums[i] = 0;
						nums[front] = temp;
						front ++;
				}
		}
}
```

### Objective-C
```objective-c
- (void)moveZeros:(NSMutableArray *)nums {
    int front = 0;
    for (int i = 0; i < nums.count; i++) {
        if (![nums[i] isEqual: @0]) {
            // move to the front
            NSNumber *tmp = nums[i];
            nums[i] = @0;
            nums[front] = tmp;
            front += 1;
        }
    }
}
```
