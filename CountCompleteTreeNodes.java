/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int count = 1;
        TreeNode work = root;
        while (work.left != null && work.right != null) {
            int depth1 = countNodesHelper(work.left);
            int depth2 = countNodesHelper(work.right);
            count *= 2;
            if (depth1 > depth2) {
                work = work.left;
            } else {
                work = work.right;
                ++count;
            }
        }
        return (work.left == null) ? count : 2*count;
    }

    public int countNodesHelper(TreeNode root) {
        int depth = 0;
        TreeNode work = root;
        while (work != null) {
            ++depth;
            work = work.left;
        }
        return depth;
    }
}
