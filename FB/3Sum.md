# 15. 3Sum
Given an array S of n integers, are there elements a, b, c in S
such that a + b + c = 0? Find all unique triplets in the array which
gives the sum of zero

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
```
[
	[-1, 0, 1],
	[-1, -1, 2]
]
```

### Java

```java
public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> results = new ArrayList<List<List<Integer>>();
	// sort it first
	Arrays.sort(nums);

	for (int i = 0; i < nums.length - 2; i ++) {

		if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
			int start = i + 1;
			int end = nums.length - 1;
			int target = 0 - nums[i];
			while (start < end) {
				if (nums[start] + nums[end] == target) {
					results.add(Arrays.asList(nums[i], nums[start], nums[end]));

					while (start < end && nums[start] == nums[start + 1]) {
						start ++; // same value in the array -> skip it
					}
					while (start < end && nums[end] == nums[end - 1]){
						end --;
					}
					start++;
					end--;
				} else if (nums[start] + nums[end] < target) {
					start++;
				} else {
					end--;
				}
			}
		}
	}
	return results;
}
```
### Objective-C
```objective-c
- (NSArray<NSArray<NSNumber *>*>*) threeSum:(NSArray<NSNumber *> *)nums {
    NSMutableArray<NSArray<NSNumber *>*> *result = [[NSMutableArray alloc] init];
    NSSortDescriptor *sortDescriptor = [[NSSortDescriptor alloc]
                                        initWithKey: @"self"
                                        ascending: YES];
    NSArray *sortedNums = [nums sortedArrayUsingDescriptors:@[sortDescriptor]];
    for (int i = 0; i < sortedNums.count - 2; i ++) {
        if (i != 0 && (i > 0 && sortedNums[i] == sortedNums[i-1])) {
			// if there current num is the same as the prev, skip it.
            break;
        }

        int start = i + 1;
        int end = (int)sortedNums.count - 1;
        int target = 0 - [sortedNums[i] intValue];
        while (start < end) {
            int sum = [sortedNums[start] intValue] + [sortedNums[end] intValue];
            if (sum  == target) {
                [result addObject:@[sortedNums[i], sortedNums[start], sortedNums[end]]];

                // Remeber to check dups
                while (start < end && [nums[start] isEqual:nums[start+1]]) {
                    start++;
                }
                while (start < end && [nums[end] isEqual:nums[end-1]]) {
                    end--;
                }
                start++;
                end--;
            } else if (sum < target ){
                start++;
            } else {
                end--;
            }
        }
    }
    return result;
}
```
