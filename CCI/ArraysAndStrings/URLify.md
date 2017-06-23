# URLify 

Write a method to replace all spaces in a string with '%20'.

# SOL

Need to know how many spaces in the string.
Strings are immutable in Java so we use char array.

```java
public void replaceSpaces(char[] charStr) {
	int spaceCount = 0;
	for (char c : charStr) {
		if (c == ' ') {
			spaceCount++;
		}
	}
	int oldLength = charStr.length;
	int newLength = charStr.length + spaceCount * 2;
	charStr[newLength] = '\0';
	for (int i = oldLength - 1; i >= 0; i--) {
		if (charStr[i] == ' ') {
			charStr[newLength - 1] = '0';
			charStr[newLength - 2] = '2';
			charStr[newLength - 3] = '%';
			newLength -= 3;
		} else {
			charStr[newLength - 1] = str[i];
			newLength--;
		}
	}
}
```