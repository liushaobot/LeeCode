/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i = 0; i < n; ++i)
        	end = end.next;
        if (end == null)
        	return head.next;
        ListNode nth = head;
        while (end.next != null){
        	end = end.next;
        	nth = nth.next;
        }
        nth.next = nth.next.next;
        return head;
    }
}
