/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(result, list, s.toCharArray(), 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, char[] chars, int position) {
        if (position == chars.length)
            result.add(new ArrayList<String>(list));
        else {
            for (int i = position; i < chars.length; ++i) {
                if (isPalindrome(chars, position, i)) {
                    list.add(new String(chars, position, i-position+1));
                    dfs(result, list, chars, i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(char[] chars, int from, int to) {
        while (from < to) {
            if (chars[from] != chars[to])
                return false;
            ++from;
            --to;
        }
        return true;
    }
}