/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);

        for(int len = 1; len <= n; len++){
            result[len] = new ArrayList<TreeNode>();
            for(int j=0; j<len; j++){
                for(TreeNode nodeL : result[j]){
                    for(TreeNode nodeR : result[len-j-1]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j+1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset){
        if(n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
