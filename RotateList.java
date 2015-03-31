/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)//特殊情况
            return head;
        ListNode p = head, q = head;
        int length = 0;
        while (q != null){
            ++length;
            q = q.next;
        }
        if (k % length == 0)//特殊情况
            return head;
        k = k % length;
        q = head;
        while (k-- != 0){
            q = q.next;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        ListNode res = p.next;
        p.next = null;
        q.next = head;
        return res;
    }
}
