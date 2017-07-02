# Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3. Note that the answer must be a substring, `"pwke"` is a subsequence and not a substring.


[Link to Leetcode](https://leetcode.com/problems/longest-substring-without-repeating-characters)

[Link to Code](LongestSubstring.java)

--------------------------------------------------

# SOL

First we create a map in order to store all unique letter.

Using two pointers technique because it needs to be consecutive. (first and second)


When we iterate through the string, we check if the currect character is in the map.

If it's not stored in the map, we add it into the map with it's value of index.

`map.put(s.charAt(second), second)`

If it's in the map, then we need to shift our first pointer to that `index + 1`

so that we are looking at a new consecutive unique substring.

`first = Math.max(first,map.get(s.charAt(second)) + 1);`

NOTE: Using `Math.max` to ensure that the first pointer does not go lower than itself.


