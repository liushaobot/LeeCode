/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 
5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not 
ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three 
sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;

        int[] array = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        array[0] = 1;
        --n;
        int nextUglyIndex = 1;
        while (n-- != 0) {
            array[nextUglyIndex] = Math.min(Math.min(array[i2]*2, array[i3]*3), array[i5]*5);
            while (array[i2]*2 <= array[nextUglyIndex])
                ++i2;
            while (array[i3]*3 <= array[nextUglyIndex])
                ++i3;
            while (array[i5]*5 <= array[nextUglyIndex])
                ++i5;
            ++nextUglyIndex;
        }
        return array[nextUglyIndex-1];
    }
}