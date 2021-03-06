# Is Unique

Determine if a string has all unique characters.
What if cannot use additional data structures?

# Sol

Create an array of size 128 (for ASCII) or 256 (extended ASCII)
First we will check if the `str` length is greater than 128.
If it is, then we know there must be a duplicate character, so return `false`

```java
if (str.length() > 128) { return false; }

```

Then use a for loop to iterate through the string.
For each character, if it's already in the array, return `false`, else add it in the array.

```java
public boolean isUnique(String str) {
	boolean[] array = new boolean[128];
	for (int i = 0; i < str.length(); i++) {
		int val = str.charAt(i);
		if (array[val]) {
			return false;
		} else {
			array[val] = true;
		}
	}
	return true;
}
```
