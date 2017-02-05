# Add Digits 

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

[Link to Leetcode](https://leetcode.com/problems/add-digits/)

[Link to Code](AddDigits.java)

--------------------------------
## Sol: Recursion 

We can iterate through the number and keep adding them up until there's only one digit left.
However, it takes O(N) time.

First of all, if the given number is less than 10, then we don't have to iterate through the digits,
so we just return it.

````Java
if (num < 10) {
    return num;
}
````

Create a `resultSum` variable to store the sum, and if `resultSum` is greater than 10, then we continue adding them up using recursion.
````    
        int resultSum = 0;
        while (num != 0) {
            resultSum += num % 10;
            num = num / 10;
        }
        return addDigits(resultSum);
````

------------------------------

## Sol: Digital Root

> Digital roots can be calculated with congruences in modular arithmetic rather than by adding up all the digits, a procedure that can save time in the case of very large numbers.

Wiki: [Digital Root](https://en.wikipedia.org/wiki/Digital_root)

----------------------------

Apply the concepts of **Digital Root**, we know the final sum will be `number % 9` IFF `number != 0` and also **_number is not mulitple of 9_**.

````Java
if (num == 0) {
    return 0;
}
return num % 9 == 0 ? 9 : num % 9;
````
