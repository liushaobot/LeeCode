/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

/**
 * Created by shaobo on 2016/3/27.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() == 1) return true;

        char[] c_str = s.toCharArray();
        int from = 0, to = c_str.length-1;

        while (from < to) {
            while (from < to) {
                if (Character.isLetterOrDigit(c_str[from])) {
                    break;
                } else
                    ++from;
            }

            while (from < to) {
                if (Character.isLetterOrDigit(c_str[to])) {
                    break;
                } else
                    --to;
            }
            if (c_str[from] == c_str[to] ||
                    (Character.isLetter(c_str[from]) &&
                            Character.isLetter(c_str[to]) &&
                            (c_str[from] + 32 == c_str[to] ||
                            c_str[from] - 32 == c_str[to]))) {
                ++from;
                --to;
                continue;
            }
            else
                return false;
        }
        return true;
    }
}
