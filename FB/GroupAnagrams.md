# 49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:
```
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
Note: All inputs will be in lower-case.

### Java

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = String.valueOf(chars);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<String>());
        }
        map.get(key).add(str);
    }
    return new ArrayList<List<String>>(map.values());
}
```
