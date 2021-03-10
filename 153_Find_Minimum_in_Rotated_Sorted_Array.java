class Solution {
    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length-1;
        //if L=R then we found the min;
        //L>R will never happen because it is not binary search 
        //that is finding a target
        while(L < R) {
            int mid = (L+R)/2;
            if (nums[mid] < nums[R]) {
                //in this case mid could be the min
                //thus can't do mid-1
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        //return nums[L] works the same L=R
        return nums[R];
    }
}

/*
 * solution to find the maximum
class Solution {
    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length-1;
        while(L < R) {
            int mid = (L+R)/2;
            if (nums[mid] > nums[L]) {
                L = mid;
            } else {
                R = mid - 1;
            }
        }
        return nums[L];
    }
}
*/
