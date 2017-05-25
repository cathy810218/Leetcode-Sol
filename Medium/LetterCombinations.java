// 17. Letter Combinations of a Phone Number
// Given a digit string, return all possible letter combinations that the number could represent.
public List<String> letterCombinations(String digits) {
    String[] keys = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) {
    	return result;
    }
    backtrack(result, "", digits ,keys);
}

private void backtrack(List<String> result, String temp, String digits, String[] keys) {
	if (digits.length() < 1) {
		result.add(temp);
		return;
	}

	int d = digits.charAt(0) - '0'; // "23" -> 2	
	String key = keys[d];
	for (int i = 0; i < key.length(); i ++) {
		backtrack(result, temp+key.charAt(i), digits.substring(1), keys);
	}
}