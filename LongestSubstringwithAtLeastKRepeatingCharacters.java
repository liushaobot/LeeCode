/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k)
            return 0;
        int[] count = new int[128];
        for (char c : s.toCharArray())
            ++count[c];
        char rare = s.charAt(0);
        for (char c='a'; c<='z'; c++)
            if (count[c] > 0 && count[c] < count[rare])
                rare = c;
        if (count[rare] >= k)
            return s.length();
        int max = 0;
        for (String t : s.split(rare + ""))
            max = Math.max(max, longestSubstring(t, k));
        return max;
    }
}