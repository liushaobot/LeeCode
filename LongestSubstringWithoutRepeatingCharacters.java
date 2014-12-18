/*
Given a string, find the length of the longest substring without repeating characters. For example, 
the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For 
"bbbbb" the longest substring is "b", with the length of 1.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int maxSize = 0;
        int curSize = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i){
            if (!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i), 1);
                ++curSize;
            } else {
                if (curSize > maxSize)
                    maxSize = curSize;
                int j;
                for (j = start; j <= i && s.charAt(j) != s.charAt(i); ++j){
                    hashMap.remove(s.charAt(j));
                    --curSize;
                }
                start = j + 1;
            }
        }
        hashMap.clear();
        return (maxSize > curSize) ? maxSize : curSize;
    }
}
