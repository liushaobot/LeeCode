/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

A[i] != B[j] ==> dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
A[i] == B[j] ==> dp[i][j] = dp[i-1][j-1]
*/
/**
 * Created by shaobo on 2016/3/29.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            if (word2 == null || word2.length() == 0)
                return 0;
            else
                return word2.length();
        }

        if (word2 == null || word2.length() == 0) {
            if (word1 == null || word1.length() == 0)
                return 0;
            else
                return word1.length();
        }
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int len1 = array1.length;
        int len2 = array2.length;
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i < len1+1; ++i) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2+1; ++j) {
            dp[0][j] = j;
        }

        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if (array1[i] == array2[j]) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int dist1, dist2, dist3;
                    dist1 = dp[i+1][j] + 1;
                    dist2 = dp[i][j+1] + 1;
                    dist3 = dp[i][j] + 1;
                    dp[i+1][j+1] = Math.min(Math.min(dist1, dist2), dist3);
                }
            }
        }
        return dp[len1][len2];
    }
}
