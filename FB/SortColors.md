# 75. Sort Colors
Given an array with `n` objects colored red, white or blue, sort them so that
objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.


### Java

```java
public void sortColors(int[] nums) {
    // if we see 0, move it to 0 index, if we see 2, move it to last index
    int front = 0;
    int back = nums.length - 1;
    int i = 0;
    while (i <= back) {
        if (nums[i] == 0) {
            nums[i] = nums[front];
            nums[front] = 0;
            front ++;
        }
        if (nums[i] == 2) {
            nums[i] = nums[back];
            nums[back] = 2;
            back--;
            i--; // When we move back pointer, remember to move index i backwards by 1!
        }
        i++;
    }
}
```


### Objective-C

```objective-c
- (void)sortColor:(NSMutableArray *)nums {
    int front = 0;
    int end = (int)nums.count - 1;
    int i = 0;

    while (i <= end) {
        if ([nums[i] isEqual: @0]) {
            // move to the front
            nums[i] = nums[front];
            nums[front] = @0;
            front++;
        } else if ([nums[i] isEqual:@2]) {
            // move to the back
            nums[i] = nums[end];
            nums[end] = @2;
            end--;
            i--; // IMPORTANT
        }
        i++;
    }
}
```
