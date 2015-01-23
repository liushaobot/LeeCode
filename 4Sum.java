/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique 
quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
参考：https://oj.leetcode.com/discuss/21769/java-which-references-solution-of-container-with-most-water
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = num.length;
        Arrays.sort(num);
        for (int first = 0; first < length-3;){
            for (int second = first+1; second < length-2;){
                int third = second + 1, fourth = length - 1;
                while (third < fourth){
                    int sum = num[first] + num[second] + num[third] + num[fourth];
                    if (sum == target){
                        result.add(new ArrayList<Integer>(Arrays.asList(num[first], num[second], num[third], num[fourth])));
                        do {//跳过重复项
                            ++third;
                        } while (third < fourth && num[third] == num[third-1]);
                        do {//跳过重复项
                            --fourth;
                        } while (third < fourth && num[fourth+1] == num[fourth]);
                    } else if (sum < target){
                        do {//跳过重复项
                            ++third;
                        } while (third < fourth && num[third] == num[third-1]);
                    } else {
                        do {//跳过重复项
                            --fourth;
                        } while (third < fourth && num[fourth+1] == num[fourth]);
                    }
                }
                do {//跳过重复项
                    ++second;
                } while (second < length-2 && num[second] == num[second-1]);
            }
            do {//跳过重复项
                ++first;
            } while (first < length-3 && num[first] == num[first-1]);
        }
        return result;
    }
}
