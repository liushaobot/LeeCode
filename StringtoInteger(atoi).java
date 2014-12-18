/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what
are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather 
all the input requirements up front. 
*/
public class Solution {
	public int atoi(String str) {
        int ans = 0;
        int i;
        boolean flag = true;
        for (i = 0; i < str.length() && str.charAt(i) == ' '; ++i)
        	;
        if (i < str.length() && str.charAt(i) == '+'){
        	flag = true;
        	++i;
        }
        else if (i < str.length() && str.charAt(i) == '-'){
        	flag = false;
        	++i;
        }
        int start = i, end;
        for (end = i; end < str.length()
        			&& str.charAt(end) >= '0'
        			&& str.charAt(end) <= '9'; ++end)
        	;
        String maxInt = new Integer(Integer.MAX_VALUE).toString();
        if (maxInt.length() > (end - start) ||
        	(maxInt.length() == (end -start) && str.substring(start, end).compareTo(maxInt) <= 0)){
	        for (;i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; ++i){
	        	int digit = (int)(str.charAt(i) - '0');
	        	ans = ans * 10 + digit;
	        }
	        return (flag == true) ? ans : -ans;
        } else{
        	return (flag == true) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
}
