/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    /**
     * IMPORTANT POINTS
     * if current node is involved in the path, can have both left and right gain.
     * if current node is NOT involved in the path (meaning returning to parent), 
     * can only have left or right gain
     */
    
    public int maxGain(TreeNode node){
        //no positive or negative gain for parent if no child
        if (node == null) return 0;
        
        //because there could be nagative gain, in that case don't include
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        
        //involving current node as root - can have both left and right gain
        int curMaxSum = node.val + leftGain + rightGain;
        
        //update global maxSum if curMaxSum is larger
        maxSum = Math.max(maxSum, curMaxSum);
        
        
        return node.val + Math.max(leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
