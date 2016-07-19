/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

/**
 * Created by shaobo on 2016/7/19.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        long middle;
        while (low <= high) {
            middle = ((high-low)>>1) + low;
            long tmp = middle*middle;
            if (tmp > num) {
                high = middle - 1;
            } else if (tmp < num) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) {
        if(num == 1) return true;

        long r = num/2;  
        while (r*r > num)
              r = (r + num/r) / 2;
        return (r*r == num) ? true : false;
    }
}
