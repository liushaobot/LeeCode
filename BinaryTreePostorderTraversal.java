/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal1(TreeNode root) {//trick
        if (root == null)
            return new ArrayList<Integer>();

        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode work = root;
        while (work != null || !stack.isEmpty()) {
            if (work != null) {
                stack.push(work);
                result.addFirst(work.val);
                work = work.right;
            } else {
                work = stack.pop();
                work = work.left;
            }
        }

        return result;
    }
    
    public List<Integer> postorderTraversal2(TreeNode root) {//no trick
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode work = root, pre = null;
        while (work != null || !stack.isEmpty()) {
            while (work != null) {
                stack.push(work);
                work = work.left;
            }
            work = stack.peek();
            if (work.right == null || work.right == pre) {
                result.add(work.val);
                pre = work;
                stack.pop();
                work = null;
            } else {
                work = work.right;
            }
        }

        return result;
    }
}
