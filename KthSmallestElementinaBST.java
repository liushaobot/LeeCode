/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
*/

public class Solution {
    public int kthSmallest(TreeNode root, int k) {//Binary Search 1ms
        int count = kthSmallestHelper(root.left);
        if (count >= k) {
            return kthSmallest(root.left, k);
        } else if (count + 1 < k) {
            return kthSmallest(root.right, k-count-1);
        } else {
            return root.val;
        }
    }

    public int kthSmallestHelper(TreeNode root) {
        if (root == null) return 0;
        return 1 + kthSmallestHelper(root.left) + kthSmallestHelper(root.right);
    }

    public int kthSmallest1(TreeNode root, int k) {//Inorder Traversal 2ms
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode work = root;
        int cnt = 0;

        while (work != null || !stack.isEmpty()) {
            if (work != null) {
                stack.push(work);
                work = work.left;
            } else {
                work = stack.pop();
                ++cnt;
                if (cnt == k)
                    break;
                work = work.right;
            }
        }
        return work.val;
    }
}
