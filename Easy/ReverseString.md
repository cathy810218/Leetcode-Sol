# Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given `s = "hello", return "olleh"`

[Link to Leetcode](https://leetcode.com/problems/reverse-string/)

[Link to Code](ReverseString.java)

--------------------------

## Solutions

Use two pointers to solve this problem could save time and space.
The idea is to have a pointer `i` points at the first letter,
and pointer `j` points at the last letter of the string.

After converting the given string to a character array `c[]`,
While `j > i`, do

1. Create a character variable `temp` to store the letter that `i` points to.
  ````Java
  char temp = c[i];
  ````

2. Swap the letters. 
  ````Java
  c[i] = c[j];
  c[j] = temp;
  ````

3. Move `i` forward and `j` backward.
  ````java
  i++;
  j--;
  ````

4. Finally convert the array back to string and return it.
  ````Java
  return new String(c);
  ````
