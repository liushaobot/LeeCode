/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Created by shaobo on 2016/3/28.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {//Recursive
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {//Non-recursive
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode work = root;
        //TreeNode tmp = null;
        while (work != null || !stack.isEmpty()) {
            if (work != null) {
                stack.push(work);
                work = work.left;
            } else {
                work = stack.pop();
                result.add(work.val);
                work = work.right;
            }
        }

        return result;
    }
}
