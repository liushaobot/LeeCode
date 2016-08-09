/*
Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
*/

/**
 * Created by shaobo on 2016/8/9.
 */
public class Solution {
    //https://discuss.leetcode.com/topic/50591/fermat-and-chinese-remainder/2
    public int superPow(int a, int[] b) {
        return (764 * superPow(a, b, 7) + 574 * superPow(a, b, 191)) % 1337;
    }

    public int superPow(int a, int[] b, int prime) {
        if ((a %= prime) == 0) return 0;
        int e = 0, mod = prime - 1;
        for (int digit : b) {
            e = (e*10 + digit) % mod;
        }
        int pow = 1;
        while (e != 0) {
            if ((e&1) != 0) {
                pow = pow*a%prime;
            }
            a = a*a%prime;
            e >>= 1;
        }
        return pow;
    }
}
