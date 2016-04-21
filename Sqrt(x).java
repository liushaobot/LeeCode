/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1;
        int end = x;
        int mid = 0;
        while (start <= end) {
            mid = ((end-start)>>1) + start;
            if (mid  > x/mid) {
                end = mid - 1;
            } else {
                if ((mid+1) > x/(mid+1))
                    break;
                start = mid + 1;
            }
        }
        return mid;
    }
    
    public int mySqrt2(int x) {
        //https://leetcode.com/discuss/58631/3-4-short-lines-integer-newton-every-language
        if(x <= 1) return x;

        long r = x/2;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int)r;
    }
}
