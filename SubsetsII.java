/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());

        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for (int len = 1; len <= nums.length; ++len) {
            list.clear();
            subsets(result, list, nums, 0, len);
        }

        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int pos, int len) {
        if (list.size() == len)
            result.add(new ArrayList<Integer>(list));
        else {
            for (int i = pos; i < nums.length; ++i) {
                if (i != pos && nums[i] == nums[i-1])
                    continue;
                list.add(nums[i]);
                subsets(result, list, nums, i+1, len);
                list.remove(list.size()-1);
            }
        }
    }
}