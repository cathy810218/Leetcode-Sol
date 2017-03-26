# Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

For example:


````java
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
````

````java
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
````

[Link to Leetcode](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

[Link to Code](FindAnagrams.java)

--------------------------------
## Solutions: 

When we see "Anagrams", we should immediately think about using "HashTable"

We always start with creating a integer array with length 128 (ASCII).

````Java
int[] hash = new int[128];
````

Then we put each character from the string `p` into the hash table.
````java
for (char c : p.toCharArray()) {
	hash[c]++;
}
````

Then here comes the complicated part...

Use two pointers to track your current window position.
````java
int left, right = 0;
int count = p.length(); // window size
````

So now we have two pointers: `left` and `right` and also a `count`.
`right` is the right side of our window, and `left` is the left side of the window.
Each time when we find a matched character, we subtract count by 1.

So now everything goes in the while loop that tells us that the right side
of the window is still within the `s`
````java
while (right < s.length()) {
}
````    

Inside the array, we will need to check if each character in `s` is in the hash table.
Increase the `right` pointer each time when we done checking.
````java
if (hash[s.charAt(right)] >= 1) {
	count--;
}
hash[s.charAt(right)]--;
right++;
````

when the `count` is down to 0, means we found the exact anagram.
Then add the `left` pt (index) to result list
````java
if (count == 0) {
    list.add(left);
}
````

If the window size is equal to `p.length()`, then increase `left` by 1.
We will need to reset the `count` only if the `hash[s.charAt(left)] >= 0` 
because we would not care if its less than 1. (not in the `s` string)
````java
if (right - left == p.length()) {
	if (hash[s.charAt(left)] >= 0) {
		count++;
	}
	hash[s.charAt(left)]++;
	left++;
}
````



