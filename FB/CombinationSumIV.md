# 377. Combination Sum IV

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:
```
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
```
Note that different sequences are counted as different combinations.

Therefore the output is `7`.

### Java

```java
public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    int[] res = new int[target + 1];
    for (int i = 1; i < res.length; i++) {
        for (int num : nums) {
            if (num > i) {
                break;                
            } else if (num == i) {
                res[i] += 1;
            } else {
                res[i] += res[i-num];
            }
        }
    }
    return res[target];
}
```
