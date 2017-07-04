public int thirdMax(int[] nums) {
    Arrays.sort(nums);
    if (nums.length < 3) {
        return nums[nums.length-1];
    }

    int count = 3;
    int result = nums[nums.length-1];
    for (int i = nums.length - 1; i >= 0; i--) {
        while (i != 0 && nums[i] == nums[i - 1]) {
            i--;
        }
        count--;
        if (count < 1) {
            result = nums[i];
            break;
        }
    }
    return result;
  }
}
