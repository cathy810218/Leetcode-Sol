# Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

````java
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
````

[Link to Leetcode](https://leetcode.com/problems/two-sum/)

[Link to Code](TwoSum.java)

--------------------------------
## Sol: O(N^2) 

Brute force way is to use two nested for loops.

````Java
//Time complexity O(N^2), Space O(1)
for (int i = 0; i < nums.length; i++) {
    for (int j = i + 1; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        if (sum == target) {
            // add indexes to the array
            result[0] = i;
            result[1] = j;
        }
    }
}
````
------------------------------

## Sol: HashMap O(N)

containsKey is a O(1) operation

````Java
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int curr = nums[i];
    int key = target - curr;
    if (map.containsKey(key)) {
        result[0] = map.get(key);
        result[1] = i;
    }
    map.put(curr, i);
}
````
