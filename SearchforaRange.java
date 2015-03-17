/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
Binary Search
*/
/**
 * Created by shaobo on 15-3-17.
 */
public class Solution {
    public int[] searchRange1(int[] A, int target) {
        int[] result = {-1, -1};
        int index = binarySearch(A, target);
        if (index == -1)
            return result;
        int from = index, to = index;
        while (from >= 0 && A[from] == target) -- from;
        while (to < A.length && A[to] == target) ++to;
        result[0] = from + 1;
        result[1] = to - 1;
        return result;
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
        return -1;
    }
    
    public int[] searchRange2(int[] A, int target) {
        int[] result = {-1, -1};
        binarySearch(A, target, 0, A.length-1, result);
        return result;
    }
    private void binarySearch(int[] A, int target, int from, int to, int[] result) {
    //递归的搜索target的范围
        int mid;
        while (from <= to) {
            mid = ((to - from) >> 1) + from;
            if (A[mid] < target)
                from = mid + 1;
            else if (A[mid] > target)
                to = mid - 1;
            else {
                result[0] = (result[0] >= 0) ? Math.min(result[0], mid) : mid;
                result[1] = Math.max(result[1], mid);
                binarySearch(A, target, from, mid-1, result);
                binarySearch(A, target, mid+1, to, result);
                return;
            }
        }
    }
}
