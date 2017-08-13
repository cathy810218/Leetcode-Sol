# Product of Array Except Self

Given an array of `n` integers where `n > 1`, nums, return an array output such that `output[i]` is equal to the product of all the elements of nums except `nums[i]`.

Solve it without division and in `O(n)`.

For example, given `[1,2,3,4]`, return `[24,12,8,6]`.


------------

## Sol

A quick way to do this is to multiply all the numbers together and divided by itself. BUT what if there's a zero?
Dividing `0` is not valid. Therefore, we might think about using two for loops.

The outer for loop is for iterating through the array while the inner for loop is for multiplying all other integers which will result in an `O(n^2)`

Therefore, another way to solve this problem without creating extra spacing to store values, we can multiply the digits from the very left to the current index.

For example, given `[1, 2, 3, 4]`

We first create an integer called `multiple` and set it to be `1`
Create a result array that we will return `result`.

Now in the first loop, we iterate through the given `nums` array and assign `multiple` to our `result` array, and each time we will multiply `multiple` with the current value in `nums`, then assign it to the next index in `result`.

````java
int multiple = 1;
for (int i = 0; i < nums.length; i ++) {
    result[i] = multiple;
    multiple *= nums[i];
}
````

With the example `nums = [1, 2, 3, 4]`, our result array at this point will be `[1, 1, 2, 6]`.

And we will do the same from _right to left_

````java
multiple = 1; // reasign multiple back to 1
for (int i = nums.length - 1; i >= 0; i--) {
    result[i] *= multiple; // it needs to be *=
    multiple *= nums[i];
}
````

Why do we need to use `*=`?

Because in the first for loop we get left to right, now in the second for loop we are getting right to left, and we need to combine both by multiplying them in the `result` array.

So the result array will then be `[48, 24, 8, 6]`
