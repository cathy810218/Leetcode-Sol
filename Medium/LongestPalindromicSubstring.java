public String longestPalindrome(String s) {
    int longestLength = 0;
    int index = 0;
    for (int i = 0; i < s.length(); i ++) {
        if (isPalindrome(s, i - longestLength, i)) {
            longestLength++;
            index = i;
        } else if (i - longestLength - 1 >= 0 && isPalindrome(s, i-longestLength - 1, i)) {
            longestLength += 2;
            index = i;
        }
    }
    index++;
    return s.substring(index - longestLength, index);
}

private boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        start ++;
        end--;
    }
    return true;
}
