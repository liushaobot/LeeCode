/*
Sort a linked list using insertion sort.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Created by shaobo on 2016/3/25.
 */
public class Solution {
    /**
 * Created by shaobo on 2016/3/25.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {//7ms
        if (head == null || head.next == null)//空链表或者单节点链表
            return head;

        ListNode prehead = new ListNode(Integer.MIN_VALUE);
        prehead.next = head;
        ListNode tail = head;
        head = head.next;
        tail.next = null;

        while (head != null) {
            ListNode tmp = head;//取出剩余链表的头节点
            head = tmp.next;
            if (tail != null && tail.val < tmp.val) {//如果tmp节点比已排序链表尾节点大，直接插入到已排序链表结尾
                tail.next = tmp;
                tail = tail.next;
                tail.next = null;
                continue;
            }
            ListNode find = prehead;
            while (find.next != null && find.next.val < tmp.val) {
                find = find.next;
            }
            if (find.next == null) {//tmp为最大节点
                tmp.next = null;
                find.next = tmp;
                tail = tmp;
            } else {
                tmp.next = find.next;
                find.next = tmp;
            }
        }
        return prehead.next;
    }
    
    public ListNode insertionSortList(ListNode head) {//42ms
        if (head == null || head.next == null)//空链表或者单节点链表
            return head;
        ListNode prehead = new ListNode(Integer.MIN_VALUE);
        prehead.next = null;
        while (head != null) {
            ListNode tmp = head;//取出剩余链表的头节点
            head = tmp.next;
            ListNode find = prehead;
            while (find.next != null && find.next.val < tmp.val) {
                find = find.next;
            }
            if (find.next == null) {//tmp为最大节点
                tmp.next = null;
                find.next = tmp;
            } else {
                tmp.next = find.next;
                find.next = tmp;
            }
        }
        return prehead.next;
    }
}
