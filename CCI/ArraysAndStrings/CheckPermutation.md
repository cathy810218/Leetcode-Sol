# Check Permutation

Given two strings, write a method to decide if one is a permutation of the other.

# Sol

Check if the lengths are equal, then check each character count.

```java
public boolean permutation(String s, String t) {
	if (s.length() != t.length()) {
		return false;
	}

	int[] letters = new int[128];

	for (char c : s.toCharArray()) {
		letters[s]++;
	}

	for (char c : t.toCharArray()) {
		letters[c]--;
		if (letters[c] < 0) {
			return false;
		}
	}
	return true;
}
```
