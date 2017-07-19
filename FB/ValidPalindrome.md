# 125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
`"A man, a plan, a canal: Panama"` is a palindrome.
`"race a car"` is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

### Java

```java
public boolean isPalindrome(String s) {
    if (s.length() == 0) {
        return true;
    }
    String regexStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    int start = 0;
    int end = regexStr.length() - 1;

    while (start < end) {
        if (regexStr.charAt(start) != regexStr.charAt(end)) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}
```


### Objective-C

```objective-c
- (BOOL)isPalindrome:(NSString *)s {
    NSError *error = nil;
    NSRegularExpression *regex = [NSRegularExpression regularExpressionWithPattern:@"[^A-Za-z0-9]"
                                                                           options:NSRegularExpressionCaseInsensitive
                                                                             error:&error];
    NSString *modifiedString = [regex stringByReplacingMatchesInString:s
                                                               options:0
                                                                 range:NSMakeRange(0, [s length])
                                                          withTemplate:@""].lowercaseString;
    int start = 0;
    int end = (int)modifiedString.length - 1;
    while (start < end) {
        if ([modifiedString characterAtIndex:start] != [modifiedString characterAtIndex:end]) {
            return NO;
        }
        start++;
        end--;
    }
    return YES;
}
```
