/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
                inorder.length == 0 || postorder.length == 0)
            return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int inFrom, int inTo, int[] postorder, int postFrom, int postTo) {
        if ((inFrom > inTo) || (postFrom > postTo)) return null;
        TreeNode root = new TreeNode(postorder[postTo]);
        int i;
        for (i = inFrom; i <= inTo; ++i) {
            if (inorder[i] == postorder[postTo])
                break;
        }
        int to = postFrom + (i-inFrom-1);
        root.left = buildTree(inorder, inFrom, i-1, postorder, postFrom, to);
        root.right = buildTree(inorder, i+1, inTo, postorder, to+1, postTo-1);
        return root;
    }
}
