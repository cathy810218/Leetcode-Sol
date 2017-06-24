# Palindrome Permutation

Given a string, write a function to check if it is a permutation of a palindrome.

# SOL

Use a hash table to count how many times each character appears.
Then make sure each character has even count and only one character could have odd count.

```java
public boolean isPermutationOfPalindrome(String phrase) {
	int[] table = new int[128];

	for (char c : phrase.toCharArray()) {
		if (c != ' ') {
			table[c]++;
		}
	}

	foundOdd = false;
	for (int count : table) {
		if (count % 2 == 1) {
			if (foundOdd) {
				return false;
			}
			foundOdd = true;
		}
	}
	return true;
}

```
