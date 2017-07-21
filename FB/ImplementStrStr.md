# 28. Implement strStr()


### Java
```java
public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
        return -1;
    }

    if (needle.equals("")) {
        return 0;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        if (haystack.substring(i, i + needle.length()).equals(needle)) {
            return i;
        }
    }
    return -1;
}
```
