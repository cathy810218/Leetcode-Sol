// 67. Add Binary
// Given two binary strings, return their sum (also a binary string).
// For example,
// a = "11"
// b = "1"
// Return "100".
public String addBinary(String a, String b) {
	StringBuilder str = new StringBuilder();
	int carry = 0;
	int i = a.length() - 1;
	int j = b.length() - 1;

	while (carry > 0 || i >= 0 || j >= 0) {
		int digitA = i < 0 ? 0 : a.charAt(i) - '0';
		int digitB = j < 0 ? 0 : b.charAt(j) - '0';
		i--;
		j--;
		str.insert(0, (digitA + digitB + carry) % 2);
		carry = (digitA + digitB + carry) / 2;
	}
	return str.toString();
}