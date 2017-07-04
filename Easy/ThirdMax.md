# Third Maximum Number

Given a non-empty array of integers, return the third maximum number in this array.
If it does not exist, return the maximum number. The time complexity must be in O(n).

[Link to Leetcode](https://leetcode.com/problems/third-maximum-number/#/description)

[Link to Code](ThirdMax.java)

-------------------------------------------------------

# Sol

Given an array, we're asked to return the third largest integer from the array.
We need to first sort they array.

`Arrays.sort(nums)`

Then we know if **without** duplicated integers, we could just get
`nums[nums.length-3]`.

But considering 2 other cases...

1. Given array only has 2 elements. Doing `nums[nums.length-3]` will cause
array index out of bounds exception.

2. There are duplicates in the array such as `{2, 3, 5, 8, 9, 9, 9}`.
Doing `nums[nums.length-3]` will return `9` but the correct answer should be `5`.


So first, let's take care of the first edge case.

After sorting the array, check if the length is less than 3.
`{1, 2}` -> this case we want to return `2`.
So we just simply return the last index when the length of the array is < 3.


Second, let's take care of duplicates.
Use a for loop to iterate through the array from the last index.
and inside the for loop, we need to check if current value `nums[i]` and the next
value `nums[i-1]` are equal, if they are... FOUND DUPLICATES!

And we also have to make sure that `i != 0` because `i-1` will cause index out of
bounds exception to be thrown.
Alright, so

```
while (i != 0 && nums[i] == nums[i-1]) {
  i--; // skip the current one
}
```

Then we need to have a counter that counts three different digits in the array,
so we set a `counter = 3` and subtract by 1 each time when we are in the for loop.

Once counter is down to `0`, we know this is the third largest integer in the array.
So we can just set `result = nums[i]` and don't forget to `break`!
