# 17. Letter Combinations of a Phone Number
// Given a digit string, return all possible letter combinations that the number could represent.

### Java
```java
public List<String> letterCombinations(String digits) {
    String[] keys = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) {
    	return result;
    }
    backtrack(result, "", digits ,keys);
}

private void backtrack(List<String> result, String temp, String digits, String[] keys) {
	if (digits.length() < 1) {
		result.add(temp);
		return;
	}
	int d = digits.charAt(0) - '0'; // "23" -> 2
	String key = keys[d];
	for (int i = 0; i < key.length(); i ++) {
		backtrack(result, temp+key.charAt(i), digits.substring(1), keys);
	}
}
```


### Objective-C

```objective-c
- (NSArray<NSString *> *)letterCombinations:(NSString *)digits {
    NSArray<NSString*> *keys = @[@"0", @"1", @"abc", @"def",
                                 @"ghi", @"jkl", @"mno",
                                 @"pqrs", @"wxyz"];
    NSMutableArray<NSString *> *result = [[NSMutableArray alloc] init];
    if (digits.length == 0) {
        return result;
    }
    [self createCombinations:result
                  tempString:@""
                        keys:keys
                   andDigits:digits];
    return result;
}

- (void)createCombinations:(NSMutableArray<NSString*>*)result
                tempString:(NSString *)str
                      keys:(NSArray<NSString*> *)keys
                 andDigits:(NSString *)digits {
    if (digits.length == 0) {
        [result addObject:str];
        return;
    }
    // get key
    int digit = [digits characterAtIndex:0] - '0';
    NSString *key = keys[digit];
    for (int i = 0; i < key.length; i++) {
        NSString *s = [NSString stringWithFormat:@"%@%c", str, [key characterAtIndex:i]];
        [self createCombinations:result
                      tempString:s
                            keys:keys
                       andDigits:[digits substringFromIndex:1]];
    }
}
```
