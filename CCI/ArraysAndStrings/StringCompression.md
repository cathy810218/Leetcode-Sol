# String Compression

The string aabcccccaaa would become a2b1c5a3.

# SOL

In the if statement, we need to remember to check `i + 1 >= str.length()` for the last letter.


```java
public String compressString(String str) {
	StringBuilder result = new StringBuilder();
	int count = 0;
	for (int i = 0; i < str.length(); i++) {
		count ++;
		if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
			result.append(str.charAt(i));
			result.append(count);
			count = 0;
		}
	}
	return result.length() > str.length ? result.toString() : str;
}
```
