/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and 
there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        char[] arr = new char[2010];
        int[] radix = new int[2010];
        int length = preProcess(s, arr);
        int max = 0;
        int id = 0;
        radix[0] = 0;
        for (int i = 1; i < length; ++i){
            int i_mirror = 2*id-i;
            radix[i] = (max > i) ? Math.min(max - i, radix[i_mirror]) : 0;
            while (arr[i-1-radix[i]] == arr[i+1+radix[i]])
                ++radix[i];
            if (i + radix[i] > max){
                max = i + radix[i];
                id = i;
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < length; ++i){
            if (radix[i] > maxLen){
                maxLen = radix[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - 1 - maxLen)/2;
        return s.substring(start, start + maxLen);

    }
    public int preProcess(String s, char arr[]){
        char middle = '#';
        arr[0] = '$';
        arr[1] = middle;
        int index = 2;
        int length = s.length();
        for (int i = 0; i < length; ++i){
            arr[index++] = s.charAt(i);
            arr[index++] = middle;
        }
        arr[index] = '?';
        return index;
    }
}
