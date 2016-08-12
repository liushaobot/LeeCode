/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
*/

public class Solution {
    public boolean increasingTriplet(int[] nums) { // 1ms
        if (nums == null || nums.length < 3)
            return false;
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) { small = num; } // update small if n is smaller than both
            else if (num <= big) { big = num; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) { //By myself -- 2ms
        if (nums == null || nums.length == 0)
            return false;
        int[] triplet = new int[3];
        int maxIndex = 0, current;
        triplet[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            current = search(triplet, maxIndex, nums[i]);
            if (current == -1) {
                continue;
            } else if (current <= maxIndex) {
                triplet[current] = nums[i];
            } else {
                triplet[++maxIndex] = nums[i];
                if (maxIndex == 2)
                    return true;
            }
        }
        return false;
    }
    
    private int search(int[] triplet, int len, int key) {
        int index = 0;
        while (index <= len) {
            if (triplet[index] < key) {
                ++index;
            } else if (triplet[index] > key) {
                return index;
            } else {
                return -1;
            }
        }
        return index;
    }
}