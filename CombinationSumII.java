/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, combination, 0);

        return result;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, int begin){
        if (target == 0){
            result.add(new ArrayList<Integer>(combination));
        } else {
            for (int i = begin; i != candidates.length && target >= candidates[i]; ++i){
                if (i!=begin && candidates[i]==candidates[i-1])
                    continue;
                combination.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], result, combination, i+1);
                combination.remove(combination.size()-1);
            }
        }
    }
}