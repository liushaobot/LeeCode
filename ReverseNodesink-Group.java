/*
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //空表
        if (head == null)
            return head;
        ListNode p = head, q = null;
        ListNode s, r;
        while (isNotDone(p, k)){
            int cnt = k - 1;
            while (cnt != 0){
                p = p.next;
                --cnt;
            }
            if (q != null){
                r = q.next;
                while (q.next != p){
                    s = q.next;
                    q.next = s.next;
                    s.next = p.next;
                    p.next = s;
                }
            } else {
                r = head;
                while (head != p){
                    s = head;
                    head = head.next;
                    s.next = p.next;
                    p.next = s;
                }
            }
            q = r;
            p = q.next;
        }
        return head;
    }
    public boolean isNotDone(ListNode head, int k){
        while (k != 0 && head != null){
            k--;
            head = head.next;
        }
        return (k == 0) ? true : false;
    }
}
