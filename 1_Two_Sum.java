class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //<value, index> pair
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //assumption: there is only one solution
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            //put i-th element in after the check 
            //so algorithm won't pick itself as its complement
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
