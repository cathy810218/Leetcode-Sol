# One Away

Three types of edits can be performed on strings: insert, remove and replace.
Write a function to check if two strings are one edit away.

# SOL

- first string is shorter than second string
- second string is shorter than first string
- both string are equal length

```java
public boolean oneEditAway(String s, String t) {
	int range = Math.min(s.length(), t.length());
	for (int i = 0; i < range; i ++) {
		if (s.charAt(i) != t.charAt(i)) {
			if (s.length() == t.length()) {
				// must be a replacement, the rest has to be the same
				return s.substring(i+1).equals(t.substring(i+1));
			} else if (s.length() > t.length()) {
				return s.substring(i+1).equals(t.substring(i));
			} else {
				return s.substring(i).equals(t.substring(i+1))
			}
		}
	}
	// for case such as abc and abcd
	return Math.abs(s.length() - t.length()) == 1;
}

```
