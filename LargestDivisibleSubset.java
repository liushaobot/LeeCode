/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
*/

/**
 * Created by shaobo on 2016/7/22.
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] length = new int[nums.length];
        int[] next = new int[nums.length];

        Arrays.sort(nums);
        int max = 0;
        int maxID = 0;

        for (int i = nums.length-1; i >= 0; --i) {
            for (int j = i; j < nums.length; ++j) {
                if (nums[j]%nums[i] == 0 && length[i] < 1+length[j]) {
                    length[i] = 1 + length[j];
                    next[i] = j;
                    if (length[i] > max) {
                        max = length[i];
                        maxID = i;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        while (max-- != 0) {
            res.add(nums[maxID]);
            maxID = next[maxID];
        }
        return res;
    }
    public List<Integer> largestDivisibleSubset1(int[] nums) {// By myself -- slow 145ms
        if (nums.length == 0) return new ArrayList<Integer>();

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        lists.add(list);
        for (int i = 1; i < nums.length; ++i) {
            int j;
            for (j = i-1; j >= 0; --j) {
                if (nums[i]%nums[j] == 0) {
                    int size, k;
                    if (j > 0) {
                        for (k = 0; k < lists.size(); ++k) {
                            size = lists.get(k).size();
                            if (lists.get(k).get(size - 1) == nums[j]) {
                                List<Integer> tmp = new ArrayList<Integer>(lists.get(k));
                                tmp.add(nums[i]);
                                lists.add(tmp);
                                break;
                            }
                        }
                    } else if (j == 0) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[0]);
                        tmp.add(nums[i]);
                        lists.add(tmp);
                    }
                } else if (j == 0){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    lists.add(tmp);
                }
            }
        }
        int maxID = 0;
        for (int i = 1; i < lists.size(); ++i) {
            if (lists.get(maxID).size() < lists.get(i).size())
                maxID = i;
        }

        return lists.get(maxID);
    }
}
