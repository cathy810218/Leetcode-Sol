# 90. Subsets II
Given a collection of integers that might contain duplicates, `nums`, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If `nums = [1,2,2]`, a solution is:
```
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

### Java

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>()); // add first empty list
    List<List<Integer>> lastList = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        List<List<Integer>> sublist = new ArrayList<>();
        if (i > 0 && nums[i] == nums[i - 1]) {
            // if the current value is the same as the previous, then we only need to append current number with last added list
            for (List<Integer> sub : lastList) {
                List<Integer> temp = new ArrayList<>(sub);
                temp.add(nums[i]);
                sublist.add(temp);
            }
        } else {
            for (List<Integer> sub: result) {
                List<Integer> temp = new ArrayList<>(sub);
                temp.add(nums[i]);
                sublist.add(temp);
            }
        }
        result.addAll(sublist);
        lastList = sublist;
    }
    return result;
}
```        
