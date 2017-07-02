public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    if (s.length() == 0) {
        return longestLength;		
    }

    Map<Character, Integer> map = new HashMap<>();
    int curr = 0;
    int first = 0;
    for (int secondIndex = 0; secondIndex < s.length(); secondIndex++) {
        char c = s.charAt(secondIndex);
        if (map.containsKey(c)) {
            first = Math.max(first, map.get(c) + 1);
        }
        map.put(c, secondIndex);
        longestLength = Math.max(longestLength, secondIndex - first + 1);
    }
    return longestLength;
}