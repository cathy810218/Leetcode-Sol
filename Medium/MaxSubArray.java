// 325. Maximum Size Subarray Sum Equals k
// Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
// If there isn't one, return 0 instead.
public int maxSubArray(int[] nums, int k) {
	
	Map<Integer, Integer> map = new HashMap<>();
	int maxLength = 0;
	int sum = 0;
	if (nums.length == 0 || nums == null) {
		return maxLength;
	}
	for (int i = 0; i < nums.length; i++ ) {
		sum += nums[i];
		if (k == sum) {
			maxLength = i + 1;
		}

		if (map.containsKey(sum - k)) {
			maxLength = Math.max(maxLength, i - map.get(sum - k));
		}

		if (!map.containsKey(sum)) {
			map.put(sum, i);
		}
	}
	return maxLength;
}