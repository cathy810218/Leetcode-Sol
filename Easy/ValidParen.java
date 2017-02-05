public class Solution {
    public boolean isValid(String str) {
	Stack<Character> stack = new Stack<>();
	if (str.length() % 2 == 1) { // odd
		return false;
	}
	for (char c : str.toCharArray()) {
		if (c == '{' || c == '[' || c == '(') {
			stack.push(c);
		} else {
			if (stack.isEmpty()) {
				return false;
			}
			switch (c) {
				case '}':
					if (stack.pop() != '{') {
						return false;
					}
					break;
				case ']':
					if (stack.pop() != '[') {
						return false;
					}
					break;
				case ')':
					if (stack.pop() != '(') {
						return false;
					}
					break;
			}
		}	
	}
	if (!stack.isEmpty()) {
		return false;
	}
	return true;
    }
}