# 38. Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:
```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```
`1` is read off as `"one 1"` or `11`.

`11` is read off as `"two 1s"` or `21`.

`21` is read off as `"one 2, then one 1"` or `1211`.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
```
Input: 1
Output: "1"
```
Example 2:
```
Input: 4
Output: "1211"
```

### Java

```java
public String countAndSay(int n) {
    String s = "1"; // initial string
    for (int i = 1; i < n; i++) { // i starts from 1
        s = countHelp(s);
    }
    return s;
}
private String countHelp(String s) {
    StringBuilder sb = new StringBuilder();
    char c = s.charAt(0); // first character
    int count = 1;
    for (int i = 1; i < s.length(); i ++) {
        if (s.charAt(i) == c) {
            // same as the first character
            count++;
        } else {
            sb.append(count).append(c);
            // then update c and reset count
            c = s.charAt(i);
            count = 1;
        }
    }
    sb.append(count).append(c);
    return sb.toString();
}
```

### Objective-C
```objective-c
```
