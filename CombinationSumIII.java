/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        combinationSum3(result, combination, k, n, 1);
        return result;
    }

    public void combinationSum3(List<List<Integer>> result, List<Integer> combination, int k, int n, int cur) {
        if (n == 0 && combination.size() == k) {
            result.add(new ArrayList<Integer>(combination));
        } else {
            for (int i = cur; i != 10 && combination.size() < k && n >= i; ++i) {
                combination.add(i);
                combinationSum3(result, combination, k, n-i, i+1);
                combination.remove(combination.size()-1);
            }
        }
    }
}