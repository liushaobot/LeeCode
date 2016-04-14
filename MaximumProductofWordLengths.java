/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume 
that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/
/**
 * Created by shaobo on 2016/4/14.
 */
public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        
        int[] bit = new int[words.length];

        for (int i = 0; i < words.length; ++i) {
            char[] arr = words[i].toCharArray();
            for (int j = 0; j < arr.length; ++j) {
                bit[i] |= (1 << (arr[j]-'a'));
            }
        }

        int result = 0;
        for (int i = 0; i < words.length-1; ++i) {
            for (int j = i+1; j < words.length; ++j) {
                if ((bit[i]&bit[j]) == 0 && (result < words[i].length()*words[j].length())) {
                    result = words[i].length()*words[j].length();
                }
            }
        }

        return result;
    }
}
