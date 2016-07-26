/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        TreeNode work = root;
        while (work != null) {
            if (work.left != null) {
                TreeNode leftright = findLeftRight(work.left);
                leftright.right = work.right;
                work.right = work.left;
                work.left = null;
            }
            work = work.right;
        }
    }

    public TreeNode findLeftRight(TreeNode root) {
        TreeNode work = root;
        while (work.right != null) {
            work = work.right;
        }
        return work;
    }
}
