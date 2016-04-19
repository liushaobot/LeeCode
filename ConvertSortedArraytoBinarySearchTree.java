/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = ((high-low)>>1) + low;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);
        return root;
    }
}
