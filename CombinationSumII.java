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
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, hashSet, combination, 0);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Iterator<List<Integer>> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    private void combinationSum(int[] candidates, int target, HashSet<List<Integer>> hashSet, List<Integer> combination, int begin){
        if (target == 0){
            hashSet.add(new ArrayList<Integer>(combination));
        } else {
            for (int i = begin; i != candidates.length && target >= candidates[i]; ++i){
                combination.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], hashSet, combination, i+1);
                combination.remove(combination.size()-1);
            }
        }
    }
}