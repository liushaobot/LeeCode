/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return  new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> path = new Stack<TreeNode>();
        pathSum(root, sum, result, path);

        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, Stack<TreeNode> path) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                Iterator<TreeNode> iterator = path.iterator();
                List<Integer> list = new ArrayList<Integer>();
                while (iterator.hasNext()) {
                    list.add(iterator.next().val);
                }
                list.add(root.val);
                result.add(list);
            }
            return;
        }
        path.push(root);
        if (root.left != null) {
            pathSum(root.left, sum-root.val, result, path);
        }
        if (root.right != null) {
            pathSum(root.right, sum-root.val, result, path);
        }
        path.pop();
    }
}