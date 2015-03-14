/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
Dynamic Programming(动态规划)
*/
public class Solution {
    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int from = -1;
        char[] S = s.toCharArray();
        for(int j=0;j<S.length;j++){
            if(S[j]=='(') stack.push(j);            
            else {//S[j] == ')'
                if (stack.isEmpty()) from=j;//from指向最右边未匹配的')'
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-from);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
    
    /*
    dp[i] = continuous valid substring till s[i]
    if s[i] == "(": dp[i] = 0
    if s[i] == ")":j=i-dp[i-1]-1, if j >= 0 and s[j] == "(", dp[i] = 2+dp[i-1]
                                                             if j-1 >= 0, dp[i] += dp[j-1]
                                  else dp[i] = 0  since no open parentheses can be found to be paired with s[i]
    */
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()+1];
        for (int i = 0; i < dp.length; ++i)
            dp[i] = 0;
        char[] S = s.toCharArray();
        int max = 0;
        for (int i = 0; i < S.length; ++i){
            if (S[i] == '(') ;
            else {//S[i] == ')'
                int j = i - dp[i] - 1;
                if (j >= 0 && S[j] == '(') {
                    dp[i+1] = 2 + dp[i];
                    if (j >= 1)
                        dp[i+1] += dp[j];
                } else
                    dp[i+1] = 0;
            }
            max = Math.max(max, dp[i+1]);
        }
        return max;
    }
}
