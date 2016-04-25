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
    public int search(int[] nums, int target) {//1ms
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {//1ms by myself
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0]==target) ? 0 : -1;
        if (nums.length == 2) return (nums[0]==target) ? 0 : ((nums[1]==target) ? 1 : -1);

        int len = nums.length;
        if (nums[0] < nums[len-1]) {//数组并没有翻转
            int index = Arrays.binarySearch(nums, target);
            return  (index >= 0) ? index : -1;
        }

        if (nums[0] > nums[1] && nums[len-2] > nums[len-1]) {//逆序数组
            int[] tmp = new int[len];
            for (int i = 0; i < len; ++i) {
                tmp[i] = nums[len-1-i];
            }
            int index = Arrays.binarySearch(tmp, target);
            return  (index >= 0) ? (len-1-index) : -1;
        }

        int start = 0, end = len-1;
        int mid;
        while (start < end-1) {
            if (nums[start] < nums[end]) {
                int index = Arrays.binarySearch(nums, start, end+1, target);
                return (index >= 0) ? index : -1;
            } else {
                mid = ((end-start)>>1) + start;
                if (nums[mid] > nums[start] && nums[mid] > target) {
                    if (target > nums[end]) {
                        int index = Arrays.binarySearch(nums, start, mid+1, target);
                        return (index >= 0) ? index : -1;
                    } else {
                        start = mid;
                    }
                } else if (nums[mid] > nums[start] && nums[mid] < target) {
                    start = mid;
                } else if (nums[mid] < nums[start] && nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < nums[start] && nums[mid] < target) {
                    if (target <= nums[end]) {
                        int index = Arrays.binarySearch(nums, mid, end+1, target);
                        return (index >= 0) ? index : -1;
                    } else {
                        end = mid;
                    }
                } else {
                    return mid;
                }
            }
        }

        return (nums[start]==target) ? start : ((nums[end]==target) ? end : -1);
    }
    
    public int search1(int[] A, int target) {//very slow
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
