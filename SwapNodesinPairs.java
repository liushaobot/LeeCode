/*
 Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be 
changed. 
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
    public ListNode swapPairs(ListNode head) {
        //空表或单节点链表
        if (head == null ||head.next == null)
            return head;
        ListNode p = head, q = null;
        head = head.next;//head指向新的头节点
        while (p != null && p.next != null){
            if (q != null){
                q.next = p.next;
                q = q.next;
                p.next = q.next;
            } else {
                q = p.next;
                p.next = q.next;
            }
            q.next = p;
            p = p.next;
            q = q.next;
        }
        return head;
    }
}
