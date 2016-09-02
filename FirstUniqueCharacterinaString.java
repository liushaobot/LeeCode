/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0)+1);
        }
        for (int i = 0; i < chars.length; ++i) {
            if (hashMap.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }
}