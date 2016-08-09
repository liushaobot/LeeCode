/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

/**
 * Created by shaobo on 2016/8/9.
 */
public class Solution {
    public int getSum(int a, int b) {
        int or = a | b;
        int and = a & b;
        int sum = 0;
        boolean flag = false;

        for (int bit = 0; bit <= 31; ++bit) {
            if ((or & (1<<bit)) == 0 && (and & (1<<bit)) == 0) { // 0 0
                if (flag) {
                    sum |= 1<<bit;
                    flag = false;
                }
            }
            if ((or & (1<<bit)) != 0 && (and & (1<<bit)) == 0) { // 1 0 or 0 1
                if (!flag) {
                    sum |= 1<<bit;
                }
            }
            if ((or & (1<<bit)) != 0 && (and & (1<<bit)) != 0) { // 1 1
                if (flag) {
                    sum |= 1<<bit;
                } else {
                    flag = true;
                }
            }
        }
        return sum;
    }
}
