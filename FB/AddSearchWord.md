# 211. Add and Search Word - Data structure design
Design a data structure that supports the following two operations:
```
void addWord(word)
bool search(word)
```

search(word) can search a literal word or a regular expression string containing only letters `a-z` or `..` A `.` means it can represent any one letter.

For example:
```
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
```
### Java

```java
class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word = "";
}
public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chars, int index, TrieNode node) {
        if (index == chars.length) {
            return !node.word.equals("");
        }
        if (chars[index] != '.') {
            return node.children[chars[index] - 'a'] != null && match(chars, index + 1, node.children[chars[index] - 'a']);
        } else {

            for (int i = 0; i < node.children.length; i ++) {
                if (node.children[i] != null && match(chars, index+1, node.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
```


### Objective-C

```objective-c
@interface WordDictionary ()
@property (strong, nonatomic) TreeNode *root;
@end

@implementation WordDictionary

- (instancetype)init {
    if (self = [super init]) {
        _root = [[TreeNode alloc] init];
    }
    return self;
}

- (void)addWord:(NSString *)word {
    TreeNode *temp = self.root;
    for (int i = 0; i < word.length; i++) {
        char c = [word characterAtIndex:i];
        if (temp.children[c - 'a'] == nil) {
            temp.children[c - 'a'] = [[TreeNode alloc] init];
        }
        temp = temp.children[c - 'a'];
    }
    temp.word = word;
}

- (BOOL)search:(NSString *)word {
    return [self matchWord:word atIndex:0 withNode:self.root];
}

- (BOOL)matchWord:(NSString *)word atIndex:(int)index withNode:(TreeNode *)node {
    if (index == word.length) {
        return ![node.word isEqualToString:@""];
    }
    char c = [word characterAtIndex:index];
    if (c != '.') {
        return node.children[c - 'a'] != nil &&
              [self matchWord:word atIndex:index+1 withNode:node.children[c - 'a']];
    } else {
        // if there's a dot (could be anything)
        for (int i = 0; i < node.children.count; i++) {
            if (node.children[i] != nil &&
                [self matchWord:word atIndex:index+1 withNode:node.children[i]]) {
                return YES;
            }
        }
    }
    return NO;
}

@end
```
