/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
*/

/**
 * Created by shaobo on 2016/4/26.
 */
public class Solution {
    public boolean isValidBST1(TreeNode root) {//Recursive
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public boolean isValidBST2(TreeNode root) {//Non-recursive
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode work = root;
        TreeNode pre = null;

        while (work != null || !stack.isEmpty()) {
            if (work != null) {
                stack.push(work);
                work = work.left;
            } else {
                TreeNode tmp = stack.pop();
                if (pre != null && tmp.val <= pre.val) {
                    return false;
                }
                pre = tmp;
                work = tmp.right;
            }
        }
        return true;
    }
}
