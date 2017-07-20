# 209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer `s`,
find the minimal length of a contiguous subarray of which the `sum > s`.

If there isn't one, return `0` instead.

For example, given the array `[2,3,1,2,4,3]` and `s = 7`,
the subarray `[4,3]` has the minimal length under the problem constraint.

### Java

```java
public int minSubarrayLength(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

    while (i < nums.length) {
        sum += nums[i];
        i ++;

        while (sum >= s) {
            min = Math.min(min, i - j);
            sum -= nums[j];
            j++;
        }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
}
```
