/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
特殊样例：aaa a*a; a ab*
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int index1 = 0, index2 = 0;
        int length1 = s.length(), length2= p.length();
        while (index2 < length2){
            if ((index2 + 1 < length2 && p.charAt(index2+1) != '*') || index2 + 1 == length2){ // 下一个字符不是'*'，必须在当前位置比较
                if (index1 < length1 && Matching(s.charAt(index1), p.charAt(index2))){
                    ++index1;
                    ++index2;
                } else
                    return false;
            } else { // 下一个字符是'*'
                while (index1 < length1 && Matching(s.charAt(index1), p.charAt(index2))){
                    if (isMatch(s.substring(index1), p.substring(index2+2)))
                        return true;
                    ++index1;
                }
                index2 += 2;
            }
        }
        if (index1 == length1 && index2 == length2)
            return true;
        else
            return false;
    }
    public boolean Matching(char s, char p){
        if (p == '.' || s == p)
            return true;
        else
            return false;
    }
}
