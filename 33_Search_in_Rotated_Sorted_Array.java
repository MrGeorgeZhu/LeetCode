class Solution {
    public int search(int[] nums, int target) {
        //insight: once we know the pivot point, 
        //make that the new starting point.
        //%the new indices by array.length to get
        //actual index.
        int pivot = findPivot(nums);
        int L = pivot;
        int R = nums.length-1 + pivot;
        while (L <= R) {
            int mid = (L+R)/2;
            int curValue = nums[mid%nums.length];
            if (curValue == target) {
                return mid%nums.length;
            } 
            else if (curValue < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return -1;
    }
    
    //pre: a rotated sorted array in ascending order
    //post: returns the index of piviot point A.K.A min num
    private int findPivot(int[] nums){
        int L = 0;
        int R = nums.length-1;
        while(L < R) {
            int mid = (L+R)/2;
            if (nums[mid] > nums[R]) {
                L = mid+1;
            } else {
                R = mid;
            }
        }
        return L;
    }
}
