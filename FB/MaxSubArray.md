# 325. Maximum Size Subarray Sum Equals k
Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Given `nums = [1, -1, 5, -2, 3]`, `k = 3`,
return `4`. (because the subarray `[1, -1, 5, -2]` sums to 3 and is the longest)

In O(N) time


### Java
```java
public int maxSubArray(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	int maxLength = 0;
	int sum = 0;
	if (nums.length == 0 || nums == null) {
		return maxLength;
	}
	for (int i = 0; i < nums.length; i++ ) {
		sum += nums[i];
		if (k == sum) {
			maxLength = i + 1;
		}

		if (map.containsKey(sum - k)) {
			maxLength = Math.max(maxLength, i - map.get(sum - k));
		}

		if (!map.containsKey(sum)) {
			map.put(sum, i);
		}
	}
	return maxLength;
}
```

### Objective-C

```objective-c
- (int)maxSubArray:(NSArray *)nums withTarget:(int)k {
    NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
    int maxLength = 0;
    int sum = 0;
    if (nums.count == 0 || nums == nil) {
        return 0;
    }
    for (int i = 0; i < nums.count; i++) {
        sum = sum + [nums[i] intValue];
        if (sum == k) {
            maxLength = i + 1;
        }
        NSNumber *prevKey = [NSNumber numberWithInt:(sum - k)];
        if (dict[prevKey] != nil) {
            int prevValueIndex = [dict[prevKey] intValue];
            int newLength = i - prevValueIndex;
            maxLength = MAX(maxLength, newLength);
        }

        NSNumber *sumNumber = [NSNumber numberWithInt:sum];
        NSNumber *value = [NSNumber numberWithInt:i];
        if (dict[sumNumber] == nil) {
            dict[sumNumber] = value;
        }
    }
    return maxLength;
}

```
