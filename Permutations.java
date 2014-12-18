/*
 Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
*/
public class Solution {
     public List<List<Integer>> permute(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        heapAlgorithm(num, num.length, result);
        return result;
     }
     public void heapAlgorithm(int[] num, int length, List<List<Integer>> result){
        if (length == 1){
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i : num){
                tmp.add(i);
            }
            result.add(tmp);
        } else{
            for (int i = 0; i < length; ++i){
                heapAlgorithm(num, length-1, result);
                if (length % 2 == 1){
                    swap(num, 1, length - 1);
                } else{
                    swap(num, i, length - 1);
                }
            }
        }
     }
     public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
     }
}
