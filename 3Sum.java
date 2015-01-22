/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the 
array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/

public class Solution {
    public List<List<Integer>> threeSum1(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length < 3)
            return result;
        Arrays.sort(num);
        int length = num.length;
        for (int start = 0; start < length-2; ++start){
            for (int middle = start+1; middle < length-1; ++middle){
                int end = Arrays.binarySearch(num, middle+1, length, -num[start]-num[middle]);
                if (end >= 0){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[start]);
                    tmp.add(num[middle]);
                    tmp.add(num[end]);
                    result.add(tmp);
                    int Middle = middle;
                    //跳过与先前重复的值
                    while (middle < length-1 && num[middle] == num[Middle])
                        ++middle;
                    middle = (middle == length-1) ? middle : middle-1;
                }
            }
            int Start = start;
            //跳过与先前重复的值
            while (start < length-2 && num[start] == num[Start])
                ++start;
            start = (start == length-2) ? start : start - 1;
        }
        return result;
    }
    
    public List<List<Integer>> threeSum2(int[] num) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int length = num.length;
        for(int start=0; start<length-2;){
            int middle = start + 1, end = length - 1;
            while(middle < end){
                int sum = num[start] + num[middle] + num[end];
                if(sum == 0){
                    answer.add(new ArrayList<Integer>(Arrays.asList(num[start],num[middle],num[end])));
                    //update j and k. skip j and k that has same value with previous one.
                    do{
                        middle++;
                    }while(middle < end && num[middle-1]==num[middle]);
                    do{
                        end--;
                    }while(middle < end && num[end+1]==num[end]);
                }
                else if(sum > 0){
                    //update k, skip k that has same value with previous one
                    do{
                        end--;
                    }while(middle < end && num[end+1]==num[end]);
                }
                else{
                    //update j, skip j that has same value with previous one
                    do{
                        middle++;
                    }while(middle < end && num[middle-1]==num[middle]);
                }
            }
            // update i. skip i that has same value with previous one
            do{
                start++;
            }while(start<length-2 && num[start-1]==num[start]);
        }
        return answer;
    }
}
