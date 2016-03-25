/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

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
 * Created by shaobo on 2016/3/25.
 */

/*
* X为链表中非环部分的长度
* Y为链表中环部分的长度
* K为slow和fast相遇的点与环的起点的距离
* m,n均为未知数
* slow走的长度len = X + nY + K
* fast走的长度2*len = X + mY +K
* 有2X + 2nY + 2K = X + mY + K
* ==> X + K = (m-2n)Y
* 即X+K的长度为(m-2n)个环的长度(Y)
* 从K点再走X步就可以到达环的起点(可能会走多个环)
* */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        ListNode begin = head;
        while (begin != slow) {//从K点再走X步就可以到达环的起点(可能会走多个环)
            begin = begin.next;
            slow = slow.next;
        }

        return begin;
    }
}
