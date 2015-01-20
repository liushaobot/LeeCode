/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
http://romannumerals.info/roman-numeral-converter/
http://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
*/
public class Solution {
    public int romanToInt1(String s) {
        HashMap hashMap = new HashMap();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); ++i){
            if (i > 0 && (Integer)hashMap.get(s.charAt(i)) > (Integer)hashMap.get(s.charAt(i-1))){
                result += (Integer)hashMap.get(s.charAt(i)) - 2 * (Integer)hashMap.get(s.charAt(i-1));
            } else {
                result += (Integer)hashMap.get(s.charAt(i));
            }
        }
        return result;
    }
    
    public int romanToInt2(String s) {
        HashMap hashMap = new HashMap();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int result = 0;
        int i;
        for (i = 0; i < s.length()-1; ++i){
            char left = s.charAt(i);
            char right = s.charAt(i+1);
            if ((Integer)hashMap.get(left) >= (Integer)hashMap.get(right)){
                result += (Integer)hashMap.get(left);
            } else{
                result += ((Integer)hashMap.get(right) - (Integer)hashMap.get(left));
                ++i;
            }
        }
        if (i == s.length()-1){
            char tmp = s.charAt(s.length()-1);
            result += (Integer)hashMap.get(tmp);
        }
        return result;
    }
}
