/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            for (int num : nums1) {
                if (map.containsKey(num) && map.get(num) >= 1) {
                    map.put(num, map.get(num)-1);
                    list.add(num);
                }
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            res[index++] = num;
        }
        return res;
    }
}
