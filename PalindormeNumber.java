/*
Determine whether an integer is a palindrome. Do this without extra space.
*/
public class Solution {
    public boolean isPalindrome(int x) {
    //从两端向中间逐位比较整数各位上的数字
        if (x < 0)
            return false;
        int div = 1;
        while (x/div >= 10)
            div *= 10;
        int mode = 10;
        while (div >= mode){
            int head = x/div%10;
            int tail = x%mode*10/mode;
            if (head != tail)
                return false;
            div /= 10;
            mode *= 10;
        }
        return true;
    }
}
