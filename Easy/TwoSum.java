public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // Best way to do it is with hashmap -> containsKey: O(1)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int key = target - curr;
            if (map.containsKey(key)) {
                result[0] = map.get(key);
                result[1] = i;
            }
            map.put(curr, i);
        }
        
        // //Time complexity O(N^2), Space O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int sum = nums[i] + nums[j];
        //         if (sum == target) {
        //             // add indexes to the array
        //             result[0] = i;
        //             result[1] = j;
        //         }
        //     }
        // }
        return result;
    }
}