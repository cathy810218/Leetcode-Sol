public boolean isUnique (String str) {
	// ASCII string has 128 characters
	if (str.length() > 128) {
		return false;
	}
	boolean[] uniqueArray = new String[128];
	for (int i = 0; i < str.length(); i++) {
		int asciiVal = str.charAt(i);
		if (uniqueArray[asciiVal]) {
			return false;
		}
		uniqueArray[asciiVal] = true;
	}
	return true;
} 
