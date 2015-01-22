/*
Write a function to find the longest common prefix string amongst an array of strings. 
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int col = strs[0].length();
        int row = strs.length;
        int shortest = 0;
        for (int i = 1; i < row; ++i){
            if (strs[i].length() < col){
                col = strs[i].length();
                shortest = i;
            }
        }
        for (int i = 0; i < col; ++i){
            for (int j = 1; j < row; ++j){
                if (strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[shortest];
    }
}
