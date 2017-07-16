# 67. Add Binary
Given two binary strings, return their sum (also a binary string).
For example,
`a = "11"`
`b = "1"`
Return `"100".`

### Java
```java
public String addBinary(String a, String b) {
	StringBuilder str = new StringBuilder();
	int carry = 0;
	int i = a.length() - 1;
	int j = b.length() - 1;

	while (carry > 0 || i >= 0 || j >= 0) {
		int digitA = i < 0 ? 0 : a.charAt(i) - '0';
		int digitB = j < 0 ? 0 : b.charAt(j) - '0';
		i--;
		j--;
		str.insert(0, (digitA + digitB + carry) % 2);
		carry = (digitA + digitB + carry) / 2;
	}
	return str.toString();
}
```

### Objective-C
```objective-c
- (NSString *)addBinary:(NSString *)a with:(NSString *)b {
    NSMutableString *str = [[NSMutableString alloc] init];
    // get last index
    int lastA = (int)a.length - 1;
    int lastB = (int)b.length - 1;
    int carry = 0;
    while (lastA >= 0 || lastB >= 0 || carry > 0) {
        int digitA = lastA < 0 ? 0 : [a characterAtIndex:lastA] - '0';
        int digitB = lastB < 0 ? 0 : [b characterAtIndex:lastB] - '0';
        int sum = carry + digitA + digitB;
        carry = sum / 2;
        int intStr = sum % 2;
        NSString *s = [NSString stringWithFormat:@"%i",intStr];
        [str insertString:s atIndex:0];
        lastA--;
        lastB--;
    }

    return str;
}
```
