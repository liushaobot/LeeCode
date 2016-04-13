/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property 
where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/

public class Solution {
    // Binary Index Tree
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////
    
    int[] count;

    public List<Integer> countSmaller2(int[] nums) {
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }

        mergeSort(nums, indexes, 0, nums.length-1);

        List<Integer> result = new ArrayList<Integer>(count.length);
        for (int i = 0; i < count.length; ++i) {
            result.add(count[i]);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] indexes, int from, int to) {
        if (to <= from)
            return;
        int mid = ((to - from) >> 1) + from;
        mergeSort(nums, indexes, from, mid);
        mergeSort(nums, indexes, mid+1, to);

        merge(nums, indexes, from, to);
    }

    private void merge(int[] nums, int[] indexes, int from, int to) {
        int mid = ((to - from) >> 1) + from;
        int leftIndex = from;
        int rightIndex = mid+1;
        int rightCount = 0;
        int[] newIndexes = new int[to-from+1];

        int sortIndex = 0;
        while (leftIndex <= mid && rightIndex <= to) {
            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                newIndexes[sortIndex] = indexes[rightIndex];
                ++rightCount;
                ++rightIndex;
            } else {
                newIndexes[sortIndex] = indexes[leftIndex];
                count[indexes[leftIndex]] += rightCount;
                ++leftIndex;
            }
            ++sortIndex;
        }

        while (leftIndex <= mid) {
            newIndexes[sortIndex] = indexes[leftIndex];
            count[indexes[leftIndex]] += rightCount;
            ++leftIndex;
            ++sortIndex;
        }
        while (rightIndex <= to) {
            newIndexes[sortIndex] = indexes[rightIndex];
            ++rightIndex;
            ++sortIndex;
        }

        for (int i = from; i <= to; ++i) {
            indexes[i] = newIndexes[i-from];
        }
    }

}
