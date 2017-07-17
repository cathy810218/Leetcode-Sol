// 278. First Bad Version
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
// which causes all the following ones to be bad.
public int firstBadVersion(int n) {
	int start = 1;
	int end = n;
	while (start < end) {
		int mid = start + (end - start) / 2;
		if (isBadVersion(mid)) {
			end = mid;
		} else {
			start = mid + 1;
		}
	}
	return start;
}