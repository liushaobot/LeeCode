/*
Sort a linked list in O(n log n) time using constant space complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/discuss/79276/java-5ms-quick-sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode left = new ListNode(0), leftHead = left;
        ListNode right = new ListNode(0), rightHead = right;
        ListNode mid = new ListNode(0), midHead = mid;
        int val = head.val;
        while(head != null){
            if(head.val < val){
                left.next = head;
                left = head;
            }  
            if(head.val > val){
                right.next = head;
                right = head;
            }
            if(head.val == val){
                mid.next = head;
                mid = head;
            }
            head = head.next;
        }
        left.next = null;
        right.next = null;
        mid.next = null;
    
        return concat(sortList(leftHead.next),midHead.next,sortList(rightHead.next));
    
    }
    public ListNode concat(ListNode left, ListNode mid, ListNode right){
        ListNode LeftTail = getTail(left);
        ListNode midTail = getTail(mid);
        midTail.next = right;
        if(LeftTail != null) {
            LeftTail.next = mid;
            return left;
        } else {
            return mid;
        }
    }
    public ListNode getTail(ListNode head){
        if(head == null) return head;
        while(head.next != null) head = head.next;
        return head;
    }
}

//https://leetcode.com/discuss/78254/easy-to-understand-java-solution
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid_node = head;
        ListNode temp = head.next;
        while (temp != null && temp.next != null) {
            temp = temp.next.next;
            mid_node = mid_node.next;
        }
        ListNode head2 = mid_node.next;
        mid_node.next = null;
        return merge(sortList(head), sortList(head2));
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy_node = new ListNode(-1);
        ListNode curr_node = dummy_node;
        while (head1 != null || head2 != null) {
            while (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    curr_node.next = head1;
                    head1 = head1.next;
                } else {
                    curr_node.next = head2;
                    head2 = head2.next;
                }
                curr_node = curr_node.next;
            }
            while (head1 != null) {
                curr_node.next = head1;
                head1 = head1.next;
                curr_node = curr_node.next;
            }
            while (head2 != null) {
                curr_node.next = head2;
                head2 = head2.next;
                curr_node = curr_node.next;
            }
        }
        return dummy_node.next;
    }
}
