/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
Binary Search
*/
/**
 * Created by shaobo on 15-3-17.
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        return binarySearch(A, target);
    }

    private int binarySearch(int[] A, int target) {
        int from = 0, to = A.length - 1;
        int mid;
        while (from <= to) {
            mid = ((to - from) >> 1) + from;
            if (A[mid] < target)
                from = mid + 1;
            else if (A[mid] > target)
                to = mid - 1;
            else
                return mid;
        }
        return from;
    }
}
