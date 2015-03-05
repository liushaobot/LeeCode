/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 

Divide and Conquer(分治策略)
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null)
            return null;
        int length = lists.size();
        if (length == 0)
            return null;
        if (length == 1)
            return lists.get(0);
        ListNode low, high;
        while (length != 1){
            int index;
            for (index = 0; index < length/2; ++index){
                low = lists.get(2*index);
                high = lists.get(2*index+1);
                lists.set(index, merge2Lists(low, high));
            }
            if (length%2 == 1)
                lists.set(index, lists.get(length-1));
            length = (length + 1) / 2;
        }
        return lists.get(0);
    }
    public ListNode merge2Lists(ListNode low, ListNode high){
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while (low != null && high != null){
            if (low.val < high.val){
                p.next = low;
                low = low.next;
                p = p.next;
            } else {
                p.next = high;
                high = high.next;
                p = p.next;
            }
        }
        if (low == null)
            p.next = high;
        else
            p.next = low;
        return result.next;
    }
}

public class Solution2 {
    public ListNode mergeKLists(List<ListNode> lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) { 
                return l1.val - l2.val; 
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}
