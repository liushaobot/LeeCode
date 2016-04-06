/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1,
 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 
13 = 4 + 9.
*/

public class Solution {
    public int numSquares(int n) {
        if (n == 1) return 1;

        int[] array = new int[n+1];
        array[1] = 1;
        int base;
        int min;
        for (int i = 2; i <= n; ++i) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt*sqrt == i) {
                array[i] = 1;
            } else {
                base = 1;
                min = Integer.MAX_VALUE;
                while (i > base*base) {
                    int tmp = i - base*base;
                    if (array[tmp] + 1 < min)
                        min = array[tmp] + 1;
                    ++base;
                }
                array[i] = min;
            }
        }
        return array[n];
    }
}