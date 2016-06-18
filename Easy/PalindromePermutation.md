# Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

For example,
`"code"` -> False, `"aab"` -> True, `"carerac"` -> True.

[Link to Leetcode](https://leetcode.com/problems/palindrome-permutation/)

[Link to Code](PalindromePermutation.java)

--------------------------

## Solutions

All the character MUST appear TWICE if the length of the given string is an EVEN number.
If the legnth of the given string is an odd number, then we can allow ONE chacater that appears ONCE only.

Using a hash map to store the character if it appears in the given string.
Iterating through the string, and add each character in the HashMap if it's not already in the map and then set it's value to 1. 
If the charcater is already in the map, we remove the mapping.

````Java
if (!map.containsKey(c)) {
    map.put(c,1);
} else {
    map.remove(c);
}
````
And the end result should show that the size of the map is less or equal to 1.

