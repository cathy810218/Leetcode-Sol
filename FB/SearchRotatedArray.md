# 33. Search in Rotated Sorted Array


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 0 1 2`).

You are given a target value to search.

If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.


### Java

```java
public int search(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;
    if (nums.length == 0) {
        return -1;
    }

    while (start < end) {
        int mid = start + (end - start)/2;
        if (nums[mid] == k) {
            return mid;
        }

        if (nums[start] > nums[mid]) {
            if (nums[mid] < k && nums[end] >= k) {
                // right
                start = mid  + 1;
            } else {
                // left
                end = mid - 1;
            }
        } else {
            if (nums[mid] > k && nums[start] <= k) {
                // left
                end = mid - 1;
            } else {
                // right
                start = mid + 1;
            }
        }
    }
    return nums[start] == k ? start : -1;
}
```
