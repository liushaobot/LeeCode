/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
*/

public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; ++i){
            StringBuilder stringBuilder = new StringBuilder();
            if (result.length() == 1){
                stringBuilder.append(1);
                stringBuilder.append(result.charAt(0));
            } else {
                char tmp = result.charAt(0);
                int count = 1;
                for (int j = 1; j < result.length(); ++j){
                    if (result.charAt(j) == tmp){
                        count += 1;
                    } else {
                        stringBuilder.append(count);
                        stringBuilder.append(tmp);
                        tmp = result.charAt(j);
                        count = 1;
                    }
                }
                stringBuilder.append(count);
                stringBuilder.append(tmp);
            }
            result = stringBuilder.toString();
        }
        return result;
    }
}
