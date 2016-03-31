/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null ||
                inorder.length == 0 || preorder.length == 0)
            return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preFrom, int preTo, int[] inorder, int inFrom, int inTo) {
        if ((inFrom > inTo) ) return null;
        TreeNode root = new TreeNode(preorder[preFrom]);
        int i;
        for (i = inFrom; i <= inTo; ++i) {
            if (inorder[i] == preorder[preFrom])
                break;
        }
        int to = preFrom + (i-inFrom);
        root.left = buildTree(preorder, preFrom+1, to, inorder, inFrom, i-1);
        root.right = buildTree(preorder, to+1, preTo, inorder, i+1, inTo);
        return root;
    }
}
