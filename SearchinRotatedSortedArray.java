/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
/**
 * Created by shaobo on 15-3-16.
 */
public class Solution {
    public int search(int[] A, int target) {
        /*
        特殊案例
        */
        if (A.length == 0) return -1;
        if (A.length == 1 && A[0] != target) return -1;
        if (A.length == 1 && A[0] == target) return 0;
        if (A.length == 2)
            return (A[0] == target) ? 0 : ((A[1] == target) ? 1 : -1);
        int endOfMax = indexOfmax(A);//计算最大元素的位置
        int startOfMin = endOfMax + 1;
        if (target >= A[0])
            return bSearch(A, 0, endOfMax, target);
        else
            return bSearch(A, startOfMin, A.length-1, target);
    }

    public int indexOfmax(int[] A){//利用二分搜索计算最大元素的位置
        int start = 0, end = A.length-1;
        if (A[start] < A[end]) return end;
        int mid;
        while (start != end-1){
            mid = ((end - start) >> 1) + start;
            if (A[mid] > A[start])
                start = mid;
            else
                end = mid;
        }
        return start;
    }

    public int bSearch(int[] A, int start, int end, int target){
        int mid;
        while (start <= end){
            mid = ((end - start) >> 1) + start;
            if (A[mid] < target)
                start = mid + 1;
            else if (A[mid] > target)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
