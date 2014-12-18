/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int max;
        if (length >= 2 && s.charAt(0) == s.charAt(1))
            max = 2;
        else
            max = 1;
        int len1, len2;
        int center = 0;
        boolean oddOrEven = (max == 1) ? false : true;
        int mid;
        for (mid = 1; mid < length-1; ++mid){
            boolean tmp = false;
            len1 = len2 = 0;
            len1 = lenOfMaxPalindrome(s, mid-1, mid+1) + 1;
            if (s.charAt(mid) == s.charAt(mid+1))
                len2 = lenOfMaxPalindrome(s, mid-1, mid+2) + 2;
            if (len1 < len2) {
                len1 = len2;
                tmp = true;
            }
            if (max < len1) {
                max = len1;
                center = mid;
                oddOrEven = tmp;
            }
        }
        int start = center - (max-1)/2;
        int end = center + (max-1)/2;
        if (oddOrEven == true)
            end += 1;
        return s.substring(start, end + 1);
    }
    public int lenOfMaxPalindrome(String s, int low, int high){
        int sum = 0;
        int length = s.length();
        while (low >=0 && high < length){
            if (s.charAt(low) == s.charAt(high)){
                sum += 2;
                --low;
                ++high;
            } else
                break;
        }
        return sum;
    }
}
