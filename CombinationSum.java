import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shaobo on 2015/7/20.
 */
public class Solution {
    public static void main(String[] args){
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        for (List<Integer> res : result){
            System.out.println(res);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                combination.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], result, combination, i);
                combination.remove(combination.size()-1);
            }
        }
    }
}
