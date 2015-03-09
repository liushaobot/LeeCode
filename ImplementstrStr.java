/*
 Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
        int length = haystack.length() - needle.length() + 1;
        int len = needle.length();
        for (int i = 0; i < length; ++i){
            if (haystack.substring(i, i+len).equals(needle))
                return i;
        }
        return -1;
    }
}
