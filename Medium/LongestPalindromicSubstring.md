# Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
````
Input: "babad"

Output: "bab"
````

Note: "aba" is also a valid answer.
Example:

````
Input: "cbbd"

Output: "bb"
````

## Sol

We first create a private helper function that only checks if the passed in string is palindrome with given index `start` and `end`.

````java
private boolean isPalindrome(String str, int start, int end) {
    while (start < end) {
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}
````

And our main function we will need to start from the first index of the string and if `isPalindrome`, we will increment `longestLength` by `1`.

````java
int longestLength = 0;
int index = 0;
for (int i = 0; i < str.length(); i ++) {
    if (isPalindrome(str, i - longestLength, i)) {
        longestLength++;
        index = i;
    }
}
````

Note: when calling the private `isPalindrome` function, we are passing in `i - longestLength` as the `start` index because we want to find the longest palindrome, so we need to check the next character.

So next, in the `else if` part, we are checking two things.

1. We want to check if the `str` is palindrome with `start` being `i - longestLength - 1`. Because in the first `if` we are checking `i - longestLength` for the starting index, if first `if` is `false`, we want to move our `start` backward by `1` and check it again.

Example:
Given `aba`, when
````
when
i = 0, looking at `a`
longestLength = 1
index = 0

when
i = 1, looking at `ab`
longestLength = 1
index = 0

when
i = 2,
looking at `ba` (because i - longestLength is start index)
This is the part where we need to move our start index backward by 1.

Therefore we use else if (isPalindrome(str, i - longestLength - 1, i))

So now looking at `aba` in the else if statement
longestLength += 2
index = 2

````

Before we pass in `i - longestLength - 1` in the isPalindrome function, we need to make sure that it's greater than or equal to `0`, else it's going to be index out of bounds.

````java
if (isPalindrome(str, i - longestLength, i)) {
    ...
} else if (i - longestLength - 1 >= 0 && isPalindrome(str, i - longestLength - 1, i)) {
    longestLength += 2;
    index = i;
}
````

We increment longestLength by 2 because we moved start index backward by 1.

And finally, when we return, we need to return the longest palindrome.
So we use `substring()`

Remember to increment index by 1 because the ending index in `substring` is exclusive.

````java
index++;
return str.substring(index - longestLength, index);
````
