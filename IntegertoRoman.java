/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
http://romannumerals.info/roman-numeral-converter/
http://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
*/
public class Solution {
    public String intToRoman1(int num) {
        int[] radix = {1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; num > 0; ++i){
            int cnt = num / radix[i];
            num %= radix[i];
            while (cnt-- > 0)
                result.append(symbol[i]);
        }
        return result.toString();
    }
    
    public String intToRoman2(int num) {
        StringBuilder result = new StringBuilder();
        int cnt = num / 1000;
        while (cnt-- > 0)
            result.append('M');
        num = num % 1000;
        if (num >= 900){
            result.append("CM");
            num -= 900;
        } else if (num >= 500){
            result.append('D');
            num -= 500;
            cnt = num / 100;
            while (cnt-- > 0)
                result.append('C');
            num %= 100;
        } else if (num >= 400){
            result.append("CD");
            num -= 400;
        }else if (num >= 100){
            cnt = num / 100;
            while (cnt-- > 0)
                result.append('C');
            num %= 100;
        }

        if (num >= 90){
            result.append("XC");
            num -= 90;
        } else if (num >= 50){
            result.append('L');
            num -= 50;
            cnt = num / 10;
            while (cnt-- > 0)
                result.append('X');
            num %= 10;
        } else if (num >= 40){
            result.append("XL");
            num -= 40;
        } else if (num >= 10){
            cnt = num / 10;
            while (cnt-- > 0)
                result.append('X');
            num %= 10;
        }

        if (num == 9)
            result.append("IX");
        else if (num >= 5){
            result.append('V');
            num -= 5;
            while (num-- > 0)
                result.append('I');
        } else if (num == 4)
            result.append("IV");
        else
            while (num-- > 0)
                result.append('I');
        return result.toString();
    }
}
