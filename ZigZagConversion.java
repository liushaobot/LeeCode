/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display 
 this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
*/
public class Solution {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();
        int i = 0;
        while (i < len) {
            for (int index = 0; index < nRows && i < len; index++) // vertically down
                sb[index].append(c[i++]);
            for (int index = nRows-2; index >= 1 && i < len; index--) // obliquely up
                sb[index].append(c[i++]);
        }
        for (int index = 1; index < sb.length; index++)
            sb[0].append(sb[index]);
        return sb[0].toString();
    }
}
