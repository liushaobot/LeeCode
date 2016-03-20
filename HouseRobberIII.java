/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the 
root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary 
tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

Reference : https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem   http://www.ituring.com.cn/article/60248
*/

/**
 * Created by shaobo on 2016/3/20.
 */
public class Solution {
    public int rob(TreeNode root) {//fast
        if (root == null) return 0;

        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robHelper(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] reslut = new int[2];//result[0]表示偷该节点的钱，result[1]表示不偷该节点的钱

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        reslut[0] = root.val + left[1] + right[1];
        reslut[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return reslut;
    }

    public int rob1(TreeNode root) {//very slow
        if (root == null) {
            return 0;
        }

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
