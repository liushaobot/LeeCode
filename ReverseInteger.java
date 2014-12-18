/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
/*
python
class Solution:
    # @return an integer
    def reverse(self, x):
        x = (-1 if x < 0 else 1) * int(str(abs(x))[::-1])
        if x > (2 **31 - 1) or x < -2 ** 31:
            return 0;
        else:
            return x
        
*/
public class Solution {
    public int reverse(int x) {
        int result;
        boolean flag = true;
        if (x == 0)
            return 0;
        else if (x < 0) {
            flag = false;
            x = -x;
        }
        while (x%10 == 0){
            x /= 10;
        }
        String string = new Integer(x).toString();
        string = new StringBuilder(string).reverse().toString();
        String maxInt = new Integer(Integer.MAX_VALUE).toString();
        if (string.length() >= maxInt.length() && string.compareTo(maxInt) >= 0)
            return 0;
        else {
            result = Integer.parseInt(string);
            return (flag == true) ? result : -result;
        }
    }
}
