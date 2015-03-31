/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of 
the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode p = l1, q = l2;
        ListNode head = new ListNode(0);
        ListNode r = head;
        while (p != null && q != null){
            if (p.val < q.val){
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null)
            r.next = p;
        else
            r.next = q;
        
        return head.next;
    }
}
