# 78. Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If `nums = [1,2,3]`, a solution is:

```
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

### Java

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<>()); // add initial empty array list
    for (int num : nums) {
        List<List<Integer>> sublist = new ArrayList<List<Integer>>();
        for (List<Integer> sub: result) {
            List<Integer> temp = new ArrayList<Integer>(sub);
            temp.add(num);
            sublist.add(temp);
        }
        result.addAll(sublist);
    }
    return result;
}
```


### Objective-C

```objective-c
- (NSArray<NSArray*>*)subset:(NSArray *)nums {
    NSMutableArray *result = [[NSMutableArray alloc] init];
    NSArray *emptyArray = @[];
    [result addObject:emptyArray];
    for (NSNumber *num in nums) {
        NSMutableArray *sublist = [[NSMutableArray alloc] init];
        for (NSArray *sub in result) {
            NSMutableArray *temp = [[NSMutableArray alloc] initWithArray:sub];
            [temp addObject:num];
            [sublist addObject:temp];
        }
        [result addObjectsFromArray:sublist];
    }
    return [result copy];
}
```
