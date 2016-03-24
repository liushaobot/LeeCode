/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Created by shaobo on 2016/3/24.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == null || head.next == null)
            return false;

        do {
            if (fast.next == null)
                return false;
            fast = fast.next;
            if (fast.next == null)
                return false;
            fast = fast.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }
}
