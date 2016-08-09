/*
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True
Example 2:

Input: x = 2, y = 6, z = 5
Output: False
*/

/**
 * Created by shaobo on 2016/8/9.
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return (x+y >= z) && (x == z || y == z || x+y == z || z%gcd(x,y) == 0);
    }

    private int gcd(int x, int y) { //辗转相除法
        while (y != 0) {
            int tmp = y;
            y = x%y;
            x = tmp;
        }
        return x;
    }

    private int gcd(int x, int y) { //辗转相除法 -- 递归
        return y==0 ? x : gcd(y, x%y);
    }
}
