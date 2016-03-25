/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

/**
 * Created by shaobo on 2016/3/25.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String[] strings = new String[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            strings[i] = new String(Integer.toString(nums[i]));
        }

        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String from, String to) {//逆序排序
                String first = from + to;
                String second = to + from;
                return second.compareTo(first);
            }
        });
        if (strings[0].charAt(0) == '0') return "0";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; ++i) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}
