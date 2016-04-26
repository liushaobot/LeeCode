/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers1(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers1(root, 0);
    }

    public int sumNumbers1(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            return num*10+root.val;
        } else {
            int val = 0;
            if (root.left != null)
                val += sumNumbers1(root.left, 10*num+root.val);
            if (root.right != null)
                val += sumNumbers1(root.right, 10*num+root.val);
            return val;
        }
    }
    ////////////////////////////////////////////////////////////////////////
    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<Integer>();
        sumNumbers2(root, list, 0);
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }

    public void sumNumbers2(TreeNode root, List<Integer> list, int num) {
        if (root.left == null && root.right == null) {
            list.add(num*10+root.val);
        } else {
            int curNum = num*10+root.val;
            if (root.left != null)
                sumNumbers2(root.left, list, curNum);
            if (root.right != null)
                sumNumbers2(root.right, list, curNum);
        }
    }
}
