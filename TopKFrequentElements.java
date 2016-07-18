/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> [] fre = new ArrayList[nums.length+1];
        for (int key : map.keySet()) {
            int f = map.get(key);
            if (fre[f] == null) fre[f] = new ArrayList<Integer>();
            fre[f].add(key);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for (int pos = nums.length; pos >=0 && res.size()<k; --pos) {
            if (fre[pos] != null)
                res.addAll(fre[pos]);
        }

        return res;
    }
}