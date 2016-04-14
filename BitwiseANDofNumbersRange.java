/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int t = (int) Math.ceil(Math.log(n-m+1)/Math.log(2));
        return m&n >> t << t;
    }
}