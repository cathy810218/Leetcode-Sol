public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                map.remove(c);
            }
        }
        return map.size() <= 1;
    }
}

