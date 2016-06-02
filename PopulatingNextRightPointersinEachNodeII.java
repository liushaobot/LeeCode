/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Created by shaobo on 2016/6/2.
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode head = root;//下一层的第一个结点
        TreeLinkNode pre = null;//下一层的前一个节点
        TreeLinkNode cur = null;//当前层的当前结点

        while (head != null) {
            cur = head;//转移到下一层
            head = null;
            pre = null;
            while (cur != null) {//在当前层迭代
                if (cur.left != null) {//左孩子
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {//右孩子
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
    }

    public void connect1(TreeLinkNode root) {
        TreeLinkNode head = null;//下一层的第一个结点
        TreeLinkNode pre = null;//下一层的前一个节点
        TreeLinkNode cur = root;//当前层的当前结点

        while (cur != null) {
            while (cur != null) {//在当前层迭代
                if (cur.left != null) {//左孩子
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {//右孩子
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;//转移到下一层
            head = null;
            pre = null;
        }
    }
}
