// Given two strings S and T, determine if they are both one edit distance apart.
public boolean isOneEditDistance(String s, String t) {
	int minLength = Math.min(s.length(), t.length());
	for (int i = 0; i < minLength; i ++) {
		if (s.charAt(i) != t.charAt(i)) {
			// if this current char is different
			if (s.length() == t.length()) {
				// if these strigns have the same length
				// than we must have the rest string to be the same
				return s.substring(i+1).equals(t.substring(i+1));
			} else if (s.length() > t.length()) { 
				// remove one char on the string which has longer length
				return s.substring(i+1).equals(t.substring(i));
			} else {
				return s.substring(i).equals(t.substring(i+1));
			}
		}
	}
	// if strings have different length
	// if the difference is 1, then return true
	return Math.abs(s.length() - t.length()) == 1;
}