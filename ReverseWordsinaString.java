/*
 Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

*/
public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;
        StringBuilder res = new StringBuilder("");
        String[] strings = s.split("\\s+");
        int length = strings.length;
        for (int i = length-1; i >= 0; --i){
            if (strings[i].length() == 0)
                continue;
            res.append(' ');
            res.append(strings[i]);
        }
        if (res.length() == 0)
            return res.toString();
        else
            return res.substring(1).toString();
    }
}
