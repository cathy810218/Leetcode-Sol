# 139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.


For example, given
`s = "leetcode"`
`dict = ["leet", "code"]`

Return `true` because `"leetcode"` can be segmented as
`"leet code"`.

### Java
```java
public boolean wordBreak(String s, List<String> wordList) {
    int length = s.length();
    boolean[] words = new boolean[length + 1];
    words[0] = true;
    for (int i = 1; i < length + 1; i++) {
        for (int j = 0; j < i; j++) {
            if (words[j] && wordDict.contains(s.substring(j, i))) {
                words[i] = true;
                break;
            }
        }
    }
    return words[length];
}
```


### Objective-C

```objective-c
- (BOOL)wordBreak:(NSString *)s withList:(NSArray<NSString *> *)wordList {
    int length = (int)s.length;
    NSMutableArray<NSNumber *> *words = [[NSMutableArray alloc] init];
    words[0] = @1;
    // fill up zeros in the array
    for (int i = 1; i < length + 1; i++) {
        words[i] = @0;
    }
    for (int i = 1; i < length + 1; i ++) {
        for (int j = 0; j < i; j++) {

            int length = (int)i - (int)j;
            NSRange range = NSMakeRange(j, length);
            NSString *str = [s substringWithRange:range];
            if ([words[j] isEqual:@1] && [wordList containsObject: str]) {
                words[i] = @1;
                break;
            }
        }
    }
    return words[length];
}
```
