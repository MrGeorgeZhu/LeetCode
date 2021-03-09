class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        //nums.length > 1 stated in the problem
        answer[0] = 1;
        //each element in answer[] is the product of all num
        //to the left of that index
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }
        //compute right on the fly
        int right = 1;
        for (int j = nums.length-2; j >=0; j--) {
            right *= nums[j+1];
            answer[j] = answer[j] * right;
        }
        return answer;
    }
}
