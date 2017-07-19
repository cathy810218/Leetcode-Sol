# 1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given `nums = [2, 7, 11, 15]`, target = `9`,

Because `nums[0] + nums[1] = 2 + 7 = 9`,
return `[0, 1]`.


### Java

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i ++) {
        int diff = target - nums[i];
        if (map.containsKey(diff)) {
            return new int[] {map.get(diff), i};
        }
        map.put(nums[i],i);
    }
    return new int[2];
}
```


### Objective-C

```objective-c
- (NSArray *)twoSum:(NSArray *)nums withTarget:(int)target {
    NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
    for (int i = 0; i < nums.count; i ++) {
        int diff = target - [nums[i] intValue];
        NSNumber *key = [NSNumber numberWithInt:diff];
        if (dict[key] != nil) {
            NSNumber *firstIndex = dict[key];
            NSNumber *secondIndex = [NSNumber numberWithInt: i];
            return @[firstIndex, secondIndex];
        }
        dict[nums[i]] = [NSNumber numberWithInt:i];
    }
    return nil;
}
```
