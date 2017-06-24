# String Rotation

Given isSubstring to check if one word is a substring of another.
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1.

# SOL

if s1 is a rotated string of s2, then s2s2 will definitely contains s1.

```java
public boolean isRotation(String s1, String s2) {
	if (s1.length() != s2.length()) {
		return false;
	}
	String s3 = s2 + s2;
	return isSubstring(s3, s1);
}

```
