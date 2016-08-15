/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) { // A little improvement -- 25ms
        int[] ugly = new int[n];
        int[] indexes = new int[primes.length];
        int[] values = new int[primes.length];
        Arrays.fill(values, 1);
        int next = 1;
        for (int i = 0; i < n; ++i) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; ++j) {
                if (values[j] == ugly[i]) {
                    values[j] = ugly[indexes[j]++]*primes[j];
                }
                next = Math.min(next, values[j]);
            }
        }


        return ugly[n-1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) { //By myself -- 34ms
        if (n == 1) return 1;

        int[] ugly = new int[n];
        int[] indexes = new int[primes.length];
        ugly[0] = 1;
        --n;
        int nextUglyIndex = 1;
        while (n-- != 0) {
            ugly[nextUglyIndex] = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; ++i) {
                ugly[nextUglyIndex] = Math.min(ugly[nextUglyIndex], ugly[indexes[i]]*primes[i]);
            }
            for (int i = 0; i < primes.length; ++i) {
                while (ugly[indexes[i]]*primes[i] <= ugly[nextUglyIndex]) {
                    ++indexes[i];
                }
            }
            ++nextUglyIndex;
        }

        return ugly[nextUglyIndex-1];
    }
}